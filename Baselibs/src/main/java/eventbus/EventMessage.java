package eventbus;

//由于这个事件在每个组件都会发布或接收，为了让其所有的组件都可以获取这个类的实例
//所以直接在Baselibs组件中main/java下创建一个文件EventBus，在其中写定义的事件类。

public class EventMessage {

    String account;

    public EventMessage(String account){
        this.account = account;
    }

    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account = account;
    }
}
