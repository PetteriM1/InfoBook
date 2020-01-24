package idk.plugin.infobook;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBookWritten;
import cn.nukkit.item.ItemIds;
import cn.nukkit.player.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main extends PluginBase implements Listener {

    String bookName;
    String bookAuthor;
    List<String> text = new ArrayList<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        bookName = getConfig().getString("bookName", "").replace("§", "\u00A7");
        bookAuthor = getConfig().getString("bookAuthor", "").replace("§", "\u00A7");
        getConfig().getStringList("Lines").forEach((s) -> {
            text.add(s.replace("§", "\u00A7"));
        });
        if (text == null) text = Collections.singletonList("");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        for (Item i : p.getInventory().getContents().values()) {
            if (i.getId() == ItemIds.WRITTEN_BOOK && i.getDamage() == 0) return;
        }
        ItemBookWritten book = (ItemBookWritten) Item.get(387, 0, 1);
        book.writeBook(bookAuthor, bookName, (text.size() <= 50 ? text.toArray(new String[0]) : Arrays.copyOfRange(text.toArray(new String[0]), 0, 50)));
        p.getInventory().addItem(book);
    }
}
