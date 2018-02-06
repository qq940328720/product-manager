package com.aishang.product.client.dto;

import java.util.List;

/**
 * Created by ylj on 17-12-27.
 */
public class DictionaryTreeResponse {
    List<DictionaryTreeInfo> data;

    public List<DictionaryTreeInfo> getData() {
        return data;
    }

    public void setData(List<DictionaryTreeInfo> data) {
        this.data = data;
    }
}
