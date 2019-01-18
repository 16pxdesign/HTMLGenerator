package com.company.Views;

import com.company.Model.Contacts;

import java.util.ArrayList;

/**
 * Make Builder as Index PageBuilder
 */
public interface IIndexPageBuilder {
    public IIndexPageBuilder addUsersList(ArrayList<Contacts> list);
    public Page build();


}
