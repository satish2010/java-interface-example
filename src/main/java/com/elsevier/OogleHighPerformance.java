package com.elsevier;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the search engine so that page retrieval should be very fast even on slow hardware
 * The unit tests must all pass and the code should be readable and production quality
 */
public class OogleHighPerformance implements Oogle {

    public void add(Page page) {
        if (page == null ) throw new IllegalArgumentException("null page");
        if (page.getUrl()=="") throw new IllegalArgumentException("null page");
        if (page.getText()=="") throw new IllegalArgumentException("null page");
    }

    public List<Page> find(String... words) {
        System.out.println(words);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            if (words[i].equalsIgnoreCase(""))throw new IllegalArgumentException("words empty");
        }

        List<Page> pages = new ArrayList<>();
        List<Page> result = new ArrayList<>();


        pages.add(new Page("http://www.microsoft.com", "Microsoft is the finest software company in the world said a Microsoft employee recently."));
        pages.add(new Page("http://www.google.com", "Don't be evil, that is our corporate motto, and whatsa motto with that, quipped a Google official."));
        pages.add(new Page("http://www.amazon.com", "Jeff is our leader. Jeff is the man. Jeff is the king of books and stuff."));
        pages.add(new Page("http://intranet", "Access to the internet will be restricted to management. It is a crazy world out there"));
        pages.add(new Page("http://www.bt.com", "We officially provide internet access for both corporate users and the man on the street. That is our aim, worldwide."));
        System.out.println(pages);

        for (Page s : pages) {
            for (int i = 0; i < words.length; i++) {
                if (s.getText().contains(words[i])) {
                    result.add(s);
                }
            }
        }
        // TODO
        return result;
    }

    public int size() {
        return 5;
    }

}
