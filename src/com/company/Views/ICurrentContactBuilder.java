package com.company.Views;

import com.company.Model.Contacts;

/**
 * Make Builder as Detail PageBuilder
 */
public interface ICurrentContactBuilder {
    public ICurrentContactBuilder addUserDetails(Contacts contact);
    public Page build();

    public ICurrentContactBuilder addParagraph(String text);


}
