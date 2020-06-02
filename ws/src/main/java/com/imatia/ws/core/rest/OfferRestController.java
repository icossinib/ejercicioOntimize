package com.imatia.ws.core.rest;

import com.imatia.api.core.service.IOfferService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
@ComponentScan(basePackageClasses = { com.imatia.api.core.service.IOfferService.class })
public class OfferRestController extends ORestController<IOfferService> {

    @Autowired
    private IOfferService offerService;

    @Override
    public IOfferService getService() {
        return this.offerService;
    }
}