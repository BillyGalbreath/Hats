package net.pl3x.bukkit.hats.listener;

import net.minecraft.server.v1_16_R2.NBTTagCompound;
import net.pl3x.bukkit.hats.Hats;
import net.pl3x.bukkit.hats.hat.Hat;
import net.pl3x.purpur.event.inventory.AnvilTakeResultEvent;
import net.pl3x.purpur.event.inventory.AnvilUpdateResultEvent;
import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_16_R2.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class AetherialListener implements Listener {
    private final Hats plugin;

    public AetherialListener(Hats plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAnvilUpdateResult(AnvilUpdateResultEvent event) {
        Player player = (Player) event.getViewers().get(0);
        ItemStack crown = player.getInventory().getHelmet();

        Hat hat = Hat.getHat(crown);
        if (hat != Hat.CROWN_AETHERIAL) {
            return; // not wearing a crown
        }

        if (crown.getDamage() >= crown.getType().getMaxDurability()) {
            // should be broken
            player.getInventory().setHelmet(null);
            return;
        }

        AnvilInventory inv = event.getInventory();

        // set up anvil secrets
        inv.setBypassCost(true);
        inv.setDoUnsafeEnchants(true);
    }

    @EventHandler
    public void onAnvilTakeResult(AnvilTakeResultEvent event) {
        Player player = (Player) event.getViewers().get(0);
        if (player.getGameMode() == GameMode.CREATIVE) {
            return; // don't care about creative mode
        }

        ItemStack crown = player.getInventory().getHelmet();

        Hat hat = Hat.getHat(crown);
        if (hat != Hat.CROWN_AETHERIAL) {
            return; // not wearing a crown
        }

        ItemStack result = event.getResult();
        if (result.getType().isEmpty()) {
            return; // didn't enchant anything
        }

        int cost = -1;

        AnvilInventory anvil = event.getInventory();
        if (anvil.canBypassCost()) {
            NBTTagCompound tag = CraftItemStack.asNMSCopy(event.getResult()).getTag();
            if (tag != null && !tag.hasKey("Purpur.realCost")) {
                cost = tag.getInt("Purpur.realCost");
            }
        }

        if (cost < 0) {
            cost = anvil.getRepairCost();
        }

        // check if enough durability on crown
        short maxDamage = crown.getType().getMaxDurability();
        int remaining = maxDamage - crown.getDamage();

        if (cost > remaining) {
            // let remaining cost from exp
            anvil.setBypassCost(false);
            anvil.setRepairCost(cost - remaining);

            // break helmet
            crown.setDamage(maxDamage);
            player.getInventory().setHelmet(null);
            return;
        }

        // take full cost from crown durability
        crown.damage(cost);
        player.getInventory().setHelmet(crown);
    }

    @EventHandler
    public void onMendCrown(PlayerItemMendEvent event) {
        ItemStack crown = event.getPlayer().getInventory().getHelmet();

        Hat hat = Hat.getHat(crown);
        if (hat != Hat.CROWN_AETHERIAL) {
            return; // not wearing a crown
        }

        // we do not mend the crown!
        event.setRepairAmount(0);
        event.setCancelled(true);
    }

    @EventHandler
    public void onDamageCrown(PlayerItemDamageEvent event) {
        ItemStack crown = event.getPlayer().getInventory().getHelmet();

        Hat hat = Hat.getHat(crown);
        if (hat != Hat.CROWN_AETHERIAL) {
            return; // not wearing a crown
        }

        // we do not damage the crown!
        event.setCancelled(true);
    }

    @EventHandler
    public void onEnchantCrown(PrepareAnvilEvent event) {
        ItemStack result = event.getResult();

        Hat hat = Hat.getHat(result);
        if (hat != Hat.CROWN_AETHERIAL) {
            return; // not trying to enchant a crown
        }

        if (!result.hasItemMeta()) {
            return; // no meta, no enchants
        }

        ItemMeta meta = result.getItemMeta();
        if (!meta.hasEnchants()) {
            return; // no enchants
        }

        boolean modified = false;

        if (meta.hasEnchant(Enchantment.MENDING)) {
            meta.removeEnchant(Enchantment.MENDING);
            modified = true;
        }
        if (meta.hasEnchant(Enchantment.DURABILITY)) {
            meta.removeEnchant(Enchantment.DURABILITY);
            modified = true;
        }

        // we do not enchant the crown!
        if (modified) {
            result.setItemMeta(meta);
            event.setResult(result);
        }
    }
}
