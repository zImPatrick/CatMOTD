package me.zimpatrick.testplugin;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.CachedServerIcon;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
    @Override
    public void onDisable() {}

    @EventHandler
    public void onServerListPing(ServerListPingEvent e) throws Exception {
        URL url = new URL("https://cataas.com/cat?width=64&height=64");
        BufferedImage bufferedImage = ImageIO.read(url);
        CachedServerIcon icon = getServer().loadServerIcon(bufferedImage);
        e.setServerIcon(icon);
        e.setMotd(colorMotd("cats."));
    }
    public String colorMotd(String motd) {
        StringBuilder completedStr = new StringBuilder();
        for(String str : motd.split("")) {
            Random rand = new Random();
            ChatColor randomElement = ChatColor.values()[rand.nextInt(ChatColor.values().length)];
            completedStr.append(randomElement + str);
        }
        return completedStr.toString();
    }

}
