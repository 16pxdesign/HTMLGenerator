package com.company.Views;

import com.company.Model.Contacts;

public interface ICurrentContactBuilder {
    public ICurrentContactBuilder addUserDetails(Contacts contact);
    public Page build();

    public ICurrentContactBuilder addParagraph(String text);


}
