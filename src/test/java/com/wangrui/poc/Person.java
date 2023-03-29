package com.wangrui.poc;

/**
 * Created on 2023/3/21 21:59.
 *
 * @author wangrui
 * @since 0.0.1
 */

public interface Person<T extends Person.Animal> {

    abstract class AbstraPerson implements Person<Bird> {

    }

    class Man extends AbstraPerson {

        @Override
        public void say(Person<Bird> person) {

        }
    }

    void say(Person<T> person);

    interface Animal {
    }

    class Bird implements Animal {
    }

}


