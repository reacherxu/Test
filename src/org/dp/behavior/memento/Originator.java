package org.dp.behavior.memento;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class Originator {
    private String state1 = "";
    private String state2 = "";
    private String state3 = "";
 
    public String getState1() {
        return state1;
    }
    public void setState1(String state1) {
        this.state1 = state1;
    }
    public String getState2() {
        return state2;
    }
    public void setState2(String state2) {
        this.state2 = state2;
    }
    public String getState3() {
        return state3;
    }
    public void setState3(String state3) {
        this.state3 = state3;
    }
    public Mementoo createMementoo(){
        return new Mementoo(BeanUtils.backupProp(this));
    }
     
    public void restoreMementoo(Mementoo Mementoo){
        BeanUtils.restoreProp(this, Mementoo.getStateMap());
    }
    public String toString(){
        return "state1="+state1+"state2="+state2+"state3="+state3;
    }
}
class Mementoo {
    private Map<String, Object> stateMap;
     
    public Mementoo(Map<String, Object> map){
        this.stateMap = map;
    }
 
    public Map<String, Object> getStateMap() {
        return stateMap;
    }
 
    public void setStateMap(Map<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}
class BeanUtils {
    public static Map<String, Object> backupProp(Object bean){
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor des: descriptors){
                String fieldName = des.getName();
                Method getter = des.getReadMethod();
                Object fieldValue = getter.invoke(bean, new Object[]{});
                if(!fieldName.equalsIgnoreCase("class")){
                    result.put(fieldName, fieldValue);
                }
            }
             
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
     
    public static void restoreProp(Object bean, Map<String, Object> propMap){
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for(PropertyDescriptor des: descriptors){
                String fieldName = des.getName();
                if(propMap.containsKey(fieldName)){
                    Method setter = des.getWriteMethod();
                    setter.invoke(bean, new Object[]{propMap.get(fieldName)});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Caretaker {
    private Map<String, Mementoo> memMap = new HashMap<String, Mementoo>();
    public Mementoo getMementoo(String index){
        return memMap.get(index);
    }
     
    public void setMementoo(String index, Mementoo Mementoo){
        this.memMap.put(index, Mementoo);
    }
}
class Client {
    public static void main(String[] args){
        Originator ori = new Originator();
        Caretaker caretaker = new Caretaker();
        ori.setState1("中国");
        ori.setState2("强盛");
        ori.setState3("繁荣");
        System.out.println("===初始化状态===\n"+ori);
         
        caretaker.setMementoo("001",ori.createMementoo());
        ori.setState1("软件");
        ori.setState2("架构");
        ori.setState3("优秀");
        System.out.println("===修改后状态===\n"+ori);
         
        ori.restoreMementoo(caretaker.getMementoo("001"));
        System.out.println("===恢复后状态===\n"+ori);
    }
}