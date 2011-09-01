package com.prime.primeportlet;

import com.prime.primeportlet.model.AgencyUser;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ViewScoped
@ManagedBean(name = "editBean")
public class EditBean implements Serializable {

    private static final long serialVersionUID = -7705706268909440728L;

    private AgencyUser agencyUser;

    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;

    public EditBean() {
    }

    @PostConstruct
    public void init(){
        agencyUser = new AgencyUser();
    }

    public AgencyUser getAgencyUser() {
        return agencyUser;
    }

    public String saveAction(){
        agencyUser.setId(System.currentTimeMillis());
        sessionBean.getAgencyUsers().add(agencyUser);
        return "list";
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}

