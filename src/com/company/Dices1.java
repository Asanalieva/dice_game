package com.company;


public class Dices1 {
    public void rollTheDice(int number) {
        switch (number) {
            case (1):
                System.out.println("""
                        +--------+
                        |        |
                        |   #    |
                        |        |
                        +--------+
                        """);
                break;
            case (2):
                System.out.println("""
                        +--------+
                        |#       |
                        |        |
                        |       #|
                        +--------+
                        """);
                break;
            case (3):
                System.out.println("""
                        +--------+
                        |#       |
                        |    #   |
                        |       #|
                        +--------+
                        """);
                break;
            case (4):
                System.out.println("""
                        +--------+
                        |#      #|
                        |        |
                        |#      #|
                        +--------+
                        """);
                break;
            case (5):
                System.out.println("""
                        +--------+
                        |#      #|
                        |   #    |
                        |#      #|
                        +--------+
                        """);
                break;
            case (6):
                System.out.println("""
                        +--------+
                        |#   #   #|
                        |         |
                        |#   #   #|
                        +--------+
                        """);
                break;


        }

    }
}
