package net.pl3x.bukkit.hats.listener;

import net.pl3x.bukkit.hats.hat.Hat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class BukkitListener implements Listener {
    private static final int HELMET_SLOT_ID = 5;

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getSlotType() != InventoryType.SlotType.ARMOR) {
            return; // not an armor slot
        }

        if (event.getRawSlot() != HELMET_SLOT_ID) {
            return; // not helmet slot
        }

        ItemStack newItem = event.getCursor();
        if (Hat.getHat(newItem) == null) {
            return; // not a hat
        }

        ItemStack prevItem = event.getCurrentItem();

        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Player) {
            // swap items (slot <-> cursor)
            ((Player) holder).getInventory().setHelmet(newItem);
            event.getWhoClicked().setItemOnCursor(prevItem);
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onInventoryShiftClick(InventoryClickEvent event) {
        if (event.getAction() != InventoryAction.MOVE_TO_OTHER_INVENTORY) {
            return; // not moving item around by shift clicking
        }

        if (event.getSlotType() == InventoryType.SlotType.ARMOR) {
            return; // don't care if shift clicking out of the armor slot
        }

        ItemStack newItem = event.getCurrentItem();
        if (Hat.getHat(newItem) == null) {
            return; // not a hat
        }

        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Player) {
            PlayerInventory inv = ((Player) holder).getInventory();
            if (inv.getHelmet() != null) {
                return; // already wearing a helmet
            }
            inv.setHelmet(newItem);
            inv.setItem(event.getSlot(), null);
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onShiftClick(PlayerInteractEntityEvent event) {
        if (event.getHand() == EquipmentSlot.HAND) {
            processInteractEvent(event);
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onShiftClick(PlayerInteractEvent event) {
        if (event.getHand() == EquipmentSlot.HAND) {
            processInteractEvent(event);
        }
    }

    private void processInteractEvent(PlayerEvent event) {
        PlayerInventory inv = event.getPlayer().getInventory();
        if (inv.getHelmet() != null) {
            return; // already wearing a helmet
        }

        ItemStack item = inv.getItemInMainHand();
        EquipmentSlot slot = EquipmentSlot.HAND;
        if (Hat.getHat(item) == null) {
            item = inv.getItemInOffHand();
            slot = EquipmentSlot.OFF_HAND;
            if (Hat.getHat(item) == null) {
                return; // not holding a hat
            }
        }

        inv.setHelmet(item);
        inv.setItem(slot, null);
    }
}
