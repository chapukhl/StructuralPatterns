package com.epam.mp.facade;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ProxyFacade implements JsonPlaceholderFacade {

    private JsonPlaceholderFacadeImpl jsonPlaceholderFacade;

    public ProxyFacade() {
        jsonPlaceholderFacade = new JsonPlaceholderFacadeImpl();
    }

    private void preExec(String methodName, Parameter[] parameters) {
        System.out.println(String.format("Method %s starting with parameters %s", methodName,
                Arrays.toString(parameters)));
    }


    private void postExec(String methodName, Object result, Duration time) {
        System.out.println(String.format("Method %s finished and returned %s by %s nanos", methodName,
                result.toString(), time.getNano()));
    }


    @Override
    public void deletePost(long id) throws IOException {
        preExec(getCurrentMethodName(), getParameters());
        Instant execStartTime = Instant.now();
        jsonPlaceholderFacade.deletePost(id);
        Instant execEndTime = Instant.now();
        postExec(getCurrentMethodName(), "Void", Duration.between(execStartTime, execEndTime));
    }


    @Override
    public void deleteComments(long id) throws IOException {
        preExec(getCurrentMethodName(), getParameters());
        Instant execStartTime = Instant.now();
        jsonPlaceholderFacade.deleteComments(id);
        Instant execEndTime = Instant.now();
        postExec(getCurrentMethodName(), "Void", Duration.between(execStartTime, execEndTime));
    }

    @Override
    public void deleteAlbums(long id) throws IOException {
        preExec(getCurrentMethodName(), getParameters());
        Instant execStartTime = Instant.now();
        jsonPlaceholderFacade.deleteAlbums(id);
        Instant execEndTime = Instant.now();
        postExec(getCurrentMethodName(), "Void", Duration.between(execStartTime, execEndTime));
    }

    @Override
    public String getPosts() throws IOException {
        preExec(getCurrentMethodName(), getParameters());
        Instant execStartTime = Instant.now();
        String result = jsonPlaceholderFacade.getPosts();
        Instant execEndTime = Instant.now();
        postExec(getCurrentMethodName(), result, Duration.between(execStartTime, execEndTime));
        return result;

    }

    @Override
    public String getComments() throws IOException {
        preExec(getCurrentMethodName(), getParameters());
        Instant execStartTime = Instant.now();
        String result = jsonPlaceholderFacade.getComments();
        Instant execEndTime = Instant.now();
        postExec(getCurrentMethodName(), result, Duration.between(execStartTime, execEndTime));
        return result;
    }

    @Override
    public String getAlbums() throws IOException {
        preExec(getCurrentMethodName(), getParameters());
        Instant execStartTime = Instant.now();
        String result = jsonPlaceholderFacade.getAlbums();
        Instant execEndTime = Instant.now();
        postExec(getCurrentMethodName(), result, Duration.between(execStartTime, execEndTime));
        return result;
    }

    private Parameter[] getParameters() {

        return  new Object (){}.getClass ().getEnclosingMethod ().getParameters();
    }

    private String getCurrentMethodName() {
        return  new Object (){}.getClass ().getEnclosingMethod ().getName();
    }
}
