package com.epam.mp.main;


import com.epam.mp.facade.CustomInvocationHandler;
import com.epam.mp.facade.JsonPlaceholderFacade;
import com.epam.mp.facade.JsonPlaceholderFacadeImpl;
import com.epam.mp.facade.ProxyFacade;

import java.io.IOException;
import java.lang.reflect.Proxy;


public class FacadeRunner {


    public static void main(String[] args) throws IOException {
        checkStaticProxy();

        checkDynamicProxy();
    }

    private static void checkDynamicProxy() throws IOException {
        JsonPlaceholderFacade original = new JsonPlaceholderFacadeImpl();
        CustomInvocationHandler handler = new CustomInvocationHandler(original);
        JsonPlaceholderFacade f = (JsonPlaceholderFacade) Proxy.newProxyInstance(JsonPlaceholderFacade.class.getClassLoader(),
                new Class[]{JsonPlaceholderFacade.class},
                handler);
        f.getPosts();
        f.deleteComments(1);
    }

    private static void checkStaticProxy() throws IOException {
        JsonPlaceholderFacade facade = new ProxyFacade();
        System.out.println(facade.getPosts());
        System.out.println("-----------------------");
        System.out.println(facade.getComments());
        System.out.println("-----------------------");
        System.out.println(facade.getAlbums());
        System.out.println("-----------------------");
        facade.deleteAlbums(1);
        facade.deletePost(1);
        facade.deleteComments(1);
    }


}
