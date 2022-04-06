package com.example.springAOPDemo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuoteService {
    private final Map<Integer, String> QUOTES_MAP = new HashMap<Integer, String>();

    public QuoteService() {
        QUOTES_MAP.put(1, "It’s not a bug – it’s an undocumented feature. (Anonymous)");
        QUOTES_MAP.put(2, "One man’s crappy software is another man’s full-time job. (Jessica Gaston)");
        QUOTES_MAP.put(3, "It works on my machine");
        QUOTES_MAP.put(4, "Any non-trivial program contains at least one bug.");
        QUOTES_MAP.put(5, "Premature optimization is the root of all evil in programming.");
    }

    @Log
    public String retrieveQuote(Integer quoteId) {
        if (quoteId < 0) {
            throw new IllegalArgumentException("Quote id cannot be negative!");
        }
        return QUOTES_MAP.get(quoteId);
    }
}
