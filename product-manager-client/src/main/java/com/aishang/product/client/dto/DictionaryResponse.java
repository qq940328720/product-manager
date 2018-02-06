package com.aishang.product.client.dto;

import java.util.List;

/**
 * Created by ylj on 17-12-27.
 */
public class DictionaryResponse {

    List<DictionaryInfo> data;

    public List<DictionaryInfo> getData() {
        return data;
    }

    public void setData(List<DictionaryInfo> data) {
        this.data = data;
    }
}
