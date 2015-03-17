

package com.tool;

import java.io.PrintStream;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

// Referenced classes of package com.tool:
//            ManagerList, MemberList

public class ManagerTrace
    implements HttpSessionBindingListener
{

    private int id;
    private ManagerList container;
    private MemberList member;

    public ManagerTrace()
    {
        container = ManagerList.getInstance();
        member = MemberList.getInstance();
        id = 0;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void valueBound(HttpSessionBindingEvent arg0)
    {
        System.out.println("上线" + id);
    }

    public void valueUnbound(HttpSessionBindingEvent arg0)
    {
        System.out.println("下线" + id);
        if(id != -1)
        {
            container.removeManager(id);
            member.removeMember(id);
        }
    }
}
