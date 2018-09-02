package idk.plugin.infobook;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBookWritten;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class Main extends PluginBase implements Listener {

    String bookName;
    String bookAuthor;
    String aa;
    String bb;
    String cc;
    String dd;
    String ee;
    String ff;
    String gg;
    String hh;
    String ii;
    String jj;
    String kk;
    String ll;
    String mm;
    String nn;
    String oo;
    String pp;
    String qq;
    String rr;
    String ss;
    String tt;

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        bookName = getConfig().getString("bookName", "").replace("§", "\u00A7");
        bookAuthor = getConfig().getString("bookAuthor", "").replace("§", "\u00A7");
        aa = getConfig().getString("line1", "").replace("§", "\u00A7");
        bb = getConfig().getString("line2", "").replace("§", "\u00A7");
        cc = getConfig().getString("line3", "").replace("§", "\u00A7");
        dd = getConfig().getString("line4", "").replace("§", "\u00A7");
        ee = getConfig().getString("line5", "").replace("§", "\u00A7");
        ff = getConfig().getString("line6", "").replace("§", "\u00A7");
        gg = getConfig().getString("line7", "").replace("§", "\u00A7");
        hh = getConfig().getString("line8", "").replace("§", "\u00A7");
        ii = getConfig().getString("line9", "").replace("§", "\u00A7");
        jj = getConfig().getString("line10", "").replace("§", "\u00A7");
        kk = getConfig().getString("line11", "").replace("§", "\u00A7");
        ll = getConfig().getString("line12", "").replace("§", "\u00A7");
        mm = getConfig().getString("line13", "").replace("§", "\u00A7");
        nn = getConfig().getString("line14", "").replace("§", "\u00A7");
        oo = getConfig().getString("line15", "").replace("§", "\u00A7");
        pp = getConfig().getString("line16", "").replace("§", "\u00A7");
        qq = getConfig().getString("line17", "").replace("§", "\u00A7");
        rr = getConfig().getString("line18", "").replace("§", "\u00A7");
        ss = getConfig().getString("line19", "").replace("§", "\u00A7");
        tt = getConfig().getString("line20", "").replace("§", "\u00A7");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        ItemBookWritten book = (ItemBookWritten) Item.get(387, 0, 1);
        String[] text = new String[20];
        text[0] = aa;
        text[1] = bb;
        text[2] = cc;
        text[3] = dd;
        text[4] = ee;
        text[5] = ff;
        text[6] = gg;
        text[7] = hh;
        text[8] = ii;
        text[9] = jj;
        text[10] = kk;
        text[11] = ll;
        text[12] = mm;
        text[13] = nn;
        text[14] = oo;
        text[15] = pp;
        text[16] = qq;
        text[17] = rr;
        text[18] = ss;
        text[19] = tt;
        book.writeBook(bookAuthor, bookName, text);
        if (!e.getPlayer().getInventory().contains(book)) e.getPlayer().getInventory().addItem(book);
    }
}
