package com.fcc.design.pattern.delegate;

/**
 * @author 傅泉明
 * @title: DelegateManagerTask
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 17:09
 */
public class DelegateManagerTask implements Task {

    private String type;
    public DelegateManagerTask(String type) {
        this.type = type;
    }

    @Override
    public void doTask() {
        System.out.println("Manager is begin doTask...");
        if ("user".equals(type)) {
            Task userTask = new User();
            userTask.doTask();
        } else if ("member".equals(type)) {
            Task memberTask = new Member();
            memberTask.doTask();
        }
        System.out.println("Manager is end doTask...");
    }

    public static void main(String[] args) {
        DelegateManagerTask managerTask = new DelegateManagerTask("user");
        managerTask.doTask();
        managerTask = new DelegateManagerTask("member");
        managerTask.doTask();
    }
}
