package com.hyuse.wot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Images {

    @Column(name = "small_icon_url")
    private String smallIcon;

    @Column(name = "contour_icon_url")
    private String contourIcon;

    @Column(name = "big_icon_url")
    private String bigIcon;

}
