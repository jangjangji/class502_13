package org.choongang.member.services;

import org.choongang.member.validators.JoinValidator;

public class MemberServiceProvider {
    private static MemberServiceProvider instance;

    private MemberServiceProvider(){}

    public static MemberServiceProvider getInstance(){
        if(instance == null){
            instance = new MemberServiceProvider();
        }
        return instance;
    }
    public JoinValidator joinValidator(){
        return new JoinValidator();
    }
    public JoinService joinService(){
        return new JoinService(joinValidator());
    }
}
