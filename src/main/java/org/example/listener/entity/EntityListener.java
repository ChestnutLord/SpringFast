package org.example.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    // Неявно на основании каждой аннотации EventListener будет создан объект типа AnnotationListener

    // Все методы помеченные @EventListener будут вызваны если отправится параметр метода (в данном случае EntityEvent)

    @EventListener
    public void acceptEntity(EntityEvent entityEvent){
        System.out.println("Выполнение какой-то логики, которая подразумевается при пробрасывании ивента  "+entityEvent);
    }
}
