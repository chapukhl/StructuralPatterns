package com.epam.mp.facade;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class CustomInvocationHandler implements InvocationHandler {

    private final JsonPlaceholderFacade facade;

    public CustomInvocationHandler(JsonPlaceholderFacade facade) {
        this.facade = facade;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        preExec(method.getName(), method.getParameters());
        Instant execStartTime = Instant.now();
        Object result = method.invoke(facade, args);
        Instant execEndTime = Instant.now();
        postExec(method.getName(), result, Duration.between(execStartTime, execEndTime));
        return result;
    }

    private void preExec(String methodName, Parameter[] parameters) {
        System.out.println(String.format("Method %s starting with parameters %s", methodName,
                Arrays.toString(parameters)));
    }


    private void postExec(String methodName, Object result, Duration time) {
        System.out.println(String.format("Method %s finished and returned %s by %s nanos", methodName,
                result, time.getNano()));
    }
}
