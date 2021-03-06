package com.liuy.service.bili;

import com.liuy.dao.entry.Bili;

import java.util.List;

public interface BiliService {
     int getCount();
     List<Bili> getRand(int limit);
}
