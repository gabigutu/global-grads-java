package com.db.intern;

public class Person {

    private float height;
    private boolean isSleeping;
    static int NO_PERSONS;

    public Person() {
        this.isSleeping = false;
    }

    private boolean isSleeping() {
        return isSleeping;
    }

    public void setSleeping(boolean sleeping) {
        if (sleeping) {

            class Alarm {
                long timestamp;

                public Alarm(long timestamp) {
                    this.timestamp = timestamp;
                }

                public long getTimestamp() {
                    return timestamp;
                }

                @Override
                public String toString() {
                    return "Alarm{" +
                            "timestamp=" + timestamp +
                            '}';
                }
            }

            long currentTimestamp = System.currentTimeMillis();
            System.out.println("Current timestamp: " + currentTimestamp);
            long after6Hours = currentTimestamp + 6 * 60 * 60 * 1000;
            Alarm alarm = new Alarm(after6Hours);
            System.out.println("Set alarm: " + alarm);

        }
        isSleeping = sleeping;
    }

    class Head {

        private float size;

        public void speak() {
            if (isSleeping()) {
                System.err.println("Person is sleeping and cannot speak");
                return;
            }
            System.out.println("Person is speaking");
        }

    }

    static class Planet {

        static void show() {
            System.out.println("Planet is Earth");
        }

    }

}
