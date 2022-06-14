/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.magiconch.backend;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ming
 */
public class Provider {
    private static LinkedList<Member> memberList = new LinkedList<>();

    public static LinkedList<Member> getMemberList() {
        return memberList;
    }

    public static void setMemberList(LinkedList<Member> memberList) {
        Provider.memberList = memberList;
    }
    
    public static void addMember(Member member){
        memberList.add(member);
    }
    
    public static void removeMember(Member member){
        memberList.removeElement(member);
    }
    
    public static void setMember(Member oldM, Member newM){
        memberList.replace(oldM, newM);
    }
    
    
}
