package ru.permyakova.main;

import ru.permyakova.animals.*;
import ru.permyakova.name_plus_human.*;
import ru.permyakova.points.*;
import ru.permyakova.secrets.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;
import static ru.permyakova.main.Power.power;

// 3 вариант
public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //----------------------------------------------------------------------------------------------

        // 1 (7)
        //Непустые Имена.
        //Измените сущность Имя из задачи 1.4.5. Гарантируйте, что:
        // -Как минимум один параметр будет иметь не null значение и не пустую строку.
        // -Имя неизменяемо.
        //Продемонстрируйте работоспособность решения на примерах.

        out.print("1.7) ");
        Name1_7[] my_names4_5;
        while (true) {
            out.print("Хочешь сам ввести имена? (1 - да, 2 - нет) ");
            if (in.hasNextInt()) {
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    while (true) {
                        out.print("Сколько у тебя будет людей? ");
                        if (in.hasNextInt()) {
                            int k = in.nextInt();
                            in.nextLine();
                            if (k > 0) {
                                my_names4_5 = new Name1_7[k];
                                for (int i = 0; i < k; i++) {
                                    out.println((i+1) + ": Введи имя (если какого-то параметра нет - нажми Enter): ");
                                    try {
                                        out.print("Введи Имя: ");
                                        String name = in.nextLine();
                                        out.print("Введи Фамилию: ");
                                        String lastname = in.nextLine();
                                        out.print("Введи Отчество: ");
                                        String patronymic = in.nextLine();
                                        my_names4_5[i] = new Name1_7(name, lastname, patronymic);
                                    } catch (IllegalArgumentException е) {
                                        out.println("Хотя бы один параметр должен быть не null и не пустой строкой!");
                                        i--;
                                    }
                                }
                                for (int i = 0; i < k; i++) {
                                    out.println(my_names4_5[i]);
                                }
                                break;
                            } else {
                                out.println("Число должно быть положительным!");
                            }
                        } else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    break;
                } else if (choice == 2) {
                    try {
                        Name1_7 name1 = new Name1_7("Иван", "Иванов", "Иванович");
                        out.println(name1);

                        Name1_7 name2 = new Name1_7("Петр", "Петров");
                        out.println(name2);

                        Name1_7 name3 = new Name1_7("Сергей");
                        out.println(name3);

                        Name1_7 name4 = new Name1_7("", "", "");
                    } catch (IllegalArgumentException e) {
                        out.println(e.getMessage());
                    }
                    break;
                }
                else {
                    out.println("Неверный выбор!");
                }
            }
            else {
                in.nextLine();
                out.println("Это должно быть число!");
            }
        }


        //-------------------------------------------------------------------------------------------------

        // 1 (8)
        //Человек меняется.
        //Измените сущность Человек из задачи 1.4.6. Новые требования включают:
        // -Рост человека всегда положительный и не более 500, его можно изменить и получить в
        //любой момент.
        // -Отца возможно задать только при создании и в дальнейшем он не изменяется, но его
        //можно получить
        // -Имя можно получить в любой момент в виде объекта типа Имя.
        //Продемонстрируйте работоспособность решения на примерах.

        out.print("1.8) ");
        HumanWParent4_6_1_8[] my_hwp4_6;
        while (true) {
            out.print("Хочешь сам ввести имена? (1 - да, 2 - нет) ");
            if (in.hasNextInt()) {
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    int ch = 1;
                    while (true) {
                        out.print("Сколько у тебя будет людей? ");
                        if (in.hasNextInt()) {
                            ch = in.nextInt();
                            if (ch >= 1) {
                                my_hwp4_6 = new HumanWParent4_6_1_8[ch];
                                in.nextLine();
                                for (int i = 0; i < ch; i++) {
                                    out.println((i + 1) + ": Пора ввести ФИО нового человека: ");
                                    out.print("Введи Имя: ");
                                    String name = in.next().trim();
                                    in.nextLine();
                                    out.print("Введи Фамилию: ");
                                    String lastname = in.nextLine().trim();
                                    out.print("Введи Отчество: ");
                                    String patronymic = in.nextLine().trim();
                                    Name1_8 myname = new Name1_8(name, lastname, patronymic);
                                    int height_human;
                                    while (true) {
                                        out.print("Введи рост твоего человека: ");
                                        if (in.hasNextInt()) {
                                            height_human = in.nextInt();
                                            in.nextLine();
                                            break;
                                        } else {
                                            in.nextLine();
                                            out.println("Это должно быть число!");
                                        }
                                    }
                                    while (true) {
                                        out.println("У данного человека будет отец? (1 - да, 2 - нет) ");
                                        if (in.hasNextInt()) {
                                            int choice2 = in.nextInt();
                                            in.nextLine();
                                            if (choice2 == 1) {
                                                out.println("Пора ввести ФИО отца: ");
                                                out.print("Введи Имя: ");
                                                String namef = in.next().trim();
                                                in.nextLine();
                                                out.print("Введи Фамилию: ");
                                                String lastnamef = in.nextLine().trim();
                                                out.print("Введи Отчество: ");
                                                String patronymicf = in.nextLine().trim();
                                                Name1_8 mynamef = new Name1_8(namef, lastnamef, patronymicf);
                                                int height_humanf;
                                                while (true) {
                                                    out.print("Введи рост отца: ");
                                                    if (in.hasNextInt()) {
                                                        height_humanf = in.nextInt();
                                                        my_hwp4_6[i] = new HumanWParent4_6_1_8(myname, height_human, new HumanWParent4_6_1_8(mynamef, height_humanf));
                                                        in.nextLine();
                                                        break;
                                                    } else {
                                                        in.nextLine();
                                                        out.println("Это должно быть число!");
                                                    }
                                                }
                                                break;
                                            } else if (choice2 == 2) {
                                                my_hwp4_6[i] = new HumanWParent4_6_1_8(myname, height_human, null);
                                                break;
                                            } else {
                                                out.println("Неверный выбор!");
                                            }
                                        } else {
                                            in.nextLine();
                                            out.println("Это должно быть число!");
                                        }
                                    }
                                }
                                out.println("Вот что получилось:");
                                for (int i = 0; i < ch; i++) out.println(my_hwp4_6[i]);
                                break;
                            } else {
                                in.nextLine();
                                out.println("Число людей должно быть больше или равно 1!");
                            }
                        } else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    break;
                } else if (choice == 2) {
                    try {
                        HumanWParent4_6_1_8 father = new HumanWParent4_6_1_8(new Name1_8("Иван"), 180);
                        out.println(father);

                        HumanWParent4_6_1_8 child = new HumanWParent4_6_1_8(new Name1_8("Петр"), 160, father);
                        out.println(child);

                        out.println(child.getFather());

                        child.setHeight(170);
                        out.println("Измененный рост ребенка: " + child.getHeight());

                    } catch (IllegalArgumentException e) {
                        out.println(e.getMessage());
                    }
                    break;
                } else {
                    out.println("Неверный выбор!");
                }
            } else {
                in.nextLine();
                out.println("Это должно быть число!");
            }
        }


        //---------------------------------------------------------------------------------------

        // 2 (2)
        // Секреты.
        //Секреты никому нельзя рассказывать. Никому кроме одного самого близкого друга! Необходимо
        //описать сущность Секрет, которая будет позволять хранить и передавать некоторый текст только
        //одному другому хранителю.
        //Состояние сущности описывают следующие сведения:
        // Текст секрета, в виде строки.
        // Имя хранителя секрета, в виде строки
        //Инициализация сущности может быть выполнена следующим образом:
        // С указанием имени хранителя секрета и текста секрета, это будет означать создание
        //нового секрета.
        // С указанием другого Секрета и именем хранителя секрета. В этом случае мы считаем, что
        //секрет был рассказан другому человеку. При передаче секрета должно произойти
        //следующее: во-первых, на консоль выводится текст вида “Имя сказал что Секрет”, где Имя
        //и Секрет представляют собой имя того кто рассказывает секрет и текст секрета
        //соответственно. Во-вторых, текст секрета у нового хранителя должен представлять собой
        //копию текста предыдущего хранителя, но с добавлением Х случайных символов в Х
        //случайных мест, где Х — это число в диапазоне от 0 до N, а N в свою очередь это 10% от
        //размера исходного текста.
        //Поведение сущности описывают следующие действия:
        // Может быть приведен к строке, строковое преставление вида“Имя: это секрет!”, где Имя –
        //это конкретное имя хранителя секрета, а остальное простой текст.
        // Можно узнать каким по очереди был данных хранитель секрета.
        // Можно узнать сколько еще человек узнали секрет после текущего хранителя
        // Можно получить имя N-го человек узнавшего секрет, причем N будет положительным для
        //случая, когда мы хотим узнать имя следующего узнавшего секрет, и отрицательным если
        //предыдущего.
        // Можно узнать разницу в количестве символов текста секрета с N-ым человеком
        //Необходимо учесть следующие требования к инкапсуляции:
        // Единственным способом получить текст секрета может быт его вывод на экран при
        //инициализации объекта.
        // Секрет может быть передан только одному другому человеку и не должно быть способа
        //рассказать один и тот же секрет нескольким людям.
        //Продемонстрируйте работоспособность решения на примерах.

        out.print("2 (2): ");

        while (true) {
            out.print("Хочешь сам ввести имена? (1 - да, 2 - нет) ");
            if (in.hasNextInt()) {
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    out.print("Введи имя первого хранителя секрета: ");
                    String KeeperName = in.nextLine().trim();
                    out.print("Введи секрет, который будет хранить " + KeeperName + ": ");
                    String SecretText = in.nextLine().trim();
                    Secret firstKeeper = new Secret(KeeperName, SecretText);

                    Secret currentKeeper = firstKeeper;
                    ArrayList<Secret> keepers = new ArrayList<>();
                    keepers.add(currentKeeper);
                    int i = 0;
                    while (true) {
                        out.print("Будем передать секрет следующему хранителю? (1 - да, 2 - нет): ");
                        if (in.hasNextInt()) {
                            int c = in.nextInt();
                            in.nextLine();
                            if (c == 1) {
                                out.print("Введи имя следующего хранителя: ");
                                String nextKeeperName = in.nextLine().trim();
                                keepers.add(new Secret(nextKeeperName, keepers.get(i)));
                                i++;
                                out.println(keepers.get(i));
                            } else if (c == 2) {
                                break;
                            } else {
                                out.println("Неверный выбор!");
                            }
                        } else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }

                    out.println("------------Пример использования методов-------------");
                    int j = 1;
                    for (Secret s : keepers) {
                        out.print(j + ": ");
                        out.println(s);
                        j++;
                    }
                    while (true) {
                        out.print("Введи номер хранителя из списка выше, о ком информацию ты хочешь узнать! ");
                        if (in.hasNextInt()){
                            int vvod = in.nextInt();
                            if (vvod <= keepers.size() && vvod > 0) {
                                vvod--;
                                out.println(keepers.get(vvod).getKeeperName() + " — " + keepers.get(vvod).getKeeperPosition() + "-й хранитель секрета");
                                out.println("Количество хранителей секрета после " + keepers.get(vvod).getKeeperName() + ": " + keepers.get(vvod).getNumberOfNextKeepers());

                                out.print("Введи смещение для поиска имени хранителя узнавшего секрет до или после текущего (Отрицательные для предыдущего, Положительные для следующего): ");
                                if (in.hasNextInt()) {
                                    int p = in.nextInt();
                                    out.println("Имя хранителя на позиции " + p + " от " + keepers.get(vvod).getKeeperName() + ": " + keepers.get(vvod).getKeeperNameAt(p));
                                } else {
                                    out.println("Неверный ввод!");
                                }

                                out.print("Введи смещение для расчета разницы в длине секрета c предыдущим либо следующим хранителем (Отрицательные для предыдущего, Положительные для следующего): ");
                                if (in.hasNextInt()) {
                                    int s = in.nextInt();
                                    out.println("Разница в длине секрета: " + keepers.get(vvod).getSecretLengthDifference(s));
                                } else {
                                    out.println("Неверный ввод!");
                                }

                                out.print("Хочешь узнать что-то ещё и про других? (1 - да, 2 - нет) ");
                                if (in.hasNextInt()) {
                                    int ch = in.nextInt();
                                    in.nextLine();
                                    if (ch == 1) {
                                        continue;
                                    } else if (ch == 2) {
                                        break;
                                    } else {
                                        out.println("Неверный выбор!");
                                    }
                                } else {
                                    in.nextLine();
                                    out.println("Это должно быть число!");
                                }
                            }
                        } else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    break;
                } else if (choice == 2) {
                    Secret originalSecret = new Secret("Алиса", "Страшный секрет!");
                    Secret secondKeeper = new Secret("Борис", originalSecret);
                    Secret thirdKeeper = new Secret("Михаил", secondKeeper);

                    out.println(originalSecret);
                    out.println(secondKeeper);
                    out.println(thirdKeeper);

                    out.println(originalSecret.getKeeperName() + " - " + secondKeeper.getKeeperPosition() + "-й хранитель секрета");
                    out.println(thirdKeeper.getNumberOfNextKeepers() + " хранителей узнали секрет после " + thirdKeeper.getKeeperName());

                    out.println("Имя хранителя до " + thirdKeeper.getKeeperName() +  ": " + thirdKeeper.getKeeperNameAt(-1));
                    out.println("Разница в длине секрета между " + originalSecret.getKeeperName() + " и " + thirdKeeper.getKeeperName() + ": " + thirdKeeper.getSecretLengthDifference(-2));

                    break;
                } else {
                    out.println("Неверный выбор!");
                }
            } else {
                in.nextLine();
                out.println("Это должно быть число!");
            }
        }


        //----------------------------------------------------------------------------------
        // 3 (5)
        // Точка координат.
        //Создайте сущность Точка, расположенную на двумерной плоскости, которая описывается:
        // Координата Х: число
        // Координата Y: число
        // Может возвращать текстовое представление вида “{X;Y}”
        //Необходимо создать три точки с разными координатами и вывести на экран их текстовое
        //представление.
        // Трехмерная точка.
        //Создайте такой подвид сущности Точка, которая будет иметь не две, а три
        //координаты на плоскости: X,Y,Z.

        out.print("3 (5): ");

        while (true) {
            out.print("Будешь сам создавать точки? (1 - да, 2 - нет) ");
            if (in.hasNextInt()) {
                int c = in.nextInt();
                in.nextLine();
                if (c == 1) {
                    double x, y, z;
                    while (true){
                        out.print("Введи X: ");
                        if (in.hasNextDouble()) {
                            x = in.nextDouble();
                            in.nextLine();
                            break;
                        }else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    while (true){
                        out.print("Введи Y: ");
                        if (in.hasNextDouble()) {
                            y = in.nextDouble();
                            in.nextLine();
                            break;
                        }else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    while (true){
                        out.print("Введи Z: ");
                        if (in.hasNextDouble()) {
                            z = in.nextDouble();
                            in.nextLine();
                            break;
                        }else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    Point3D newPoint = new Point3D(x, y, z);
                    out.println("Твоя точка: " + newPoint);
                    break;
                } else if (c == 2) {
                    Point3D point3D = new Point3D(2.1, -1.3, 5.7);
                    out.println("Трехмерная точка:");
                    out.println(point3D);
                    break;
                } else {
                    out.println("Неверный выбор!");
                }
            } else {
                in.nextLine();
                out.println("Это должно быть число!");
            }
        }


        //--------------------------------------------------------------------------------------------------------

        // 4 (3)
        //Птицы.
        //Создайте сущность Птица, которая будет являться корнем иерархии для всех, кто является
        //подвидом птицы. В разработанную сущность необходимо вынести все, что будет общим для птиц.
        //Для того чтобы определить необходимые члены класса, проанализируйте три примера птиц:
        // Воробей. Умеет петь. При пении на экран выводится строка “чырык”.
        // Кукушка. Умеет петь. При пении на экран выводится текст “ку-ку”, причем текст
        //выводится случайное количество раз в диапазоне от 1 до 10.
        // Попугай. Имеет текст и умеет петь этот текст. При инициализации обязательно
        //необходимо указать текст, который будет исполняться. При пении текст выводится не
        //весь, а первые N символов (не менее одного и не более всех символов текста), где N
        //определяется случайно

        out.println("4 (3): ");

        Bird sparrow = new Sparrow();
        Bird cuckoo = new Cuckoo();
        Bird parrot = new Parrot("Очень хорошо!");

        out.print("Воробей говорит: ");
        sparrow.sing();
        out.print("Кукушка говорит: ");
        cuckoo.sing();
        out.print("Попугай говорит: ");
        parrot.sing();


        //-----------------------------------------------------------------------------------------------------

        // 5 (4)
        //Мяуканье.
        //Разработайте метод, который принимает набор объектов способных мяукать и вызывает
        //мяуканье у каждого объекта. Мяукающие объекты должны иметь метод со следующей
        //сигнатурой:
        //public void meow();
        //Дополните решение задачи 1.5.2(Кот) так, чтобы иметь возможность передать Кота в
        //написанный вами метод и протестируйте работоспособность решения передав в него нескольких
        //котов, а также создайте любой другой произвольный класс и передайте в написанный метод его
        //объекты.

        out.print("5 (4): ");
        while (true) {
            out.print("Будешь сам вводить имена животных? (1 - да, 2 - нет) ");
            if (in.hasNextInt()) {
                int c = in.nextInt();
                in.nextLine();
                if (c == 1) {
                    ArrayList<Cat> cats = new ArrayList<>();
                    while (true) {
                        out.print("Сколько у тебя будет котиков? ");
                        if(in.hasNextInt()){
                            int vvod = in.nextInt();
                            if (vvod > 0) {
                                for (int i = 0; i < vvod; i++) {
                                    out.print("Введи имя котика " + (i+1) + ": ");
                                    cats.add(new Cat(in.next()));
                                }
                                break;
                            }
                            else {
                                in.nextLine();
                                out.println("Число должно быть положительным!");
                            }
                        }
                        else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    ArrayList<Tiger> tigers = new ArrayList<>();
                    while (true) {
                        out.print("Сколько у тебя будет тигров? ");
                        if(in.hasNextInt()){
                            int vvod = in.nextInt();
                            if (vvod > 0) {
                                for (int i = 0; i < vvod; i++) {
                                    out.print("Введи имя тигра " + (i+1) + ": ");
                                    tigers.add(new Tiger(in.next()));
                                }
                                break;
                            }
                            else {
                                in.nextLine();
                                out.println("Число должно быть положительным!");
                            }
                        }
                        else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    List<Meowable> meowables = new ArrayList<>();
                    meowables.addAll(cats);
                    meowables.addAll(tigers);
                    makeAllMeow.output(meowables);
                    break;
                } else if (c == 2) {
                    Cat cat1 = new Cat("Венти");
                    Cat cat2 = new Cat("Кейа");
                    Tiger tiger1 = new Tiger("Тишка");
                    makeAllMeow.output(List.of(cat1, cat2, tiger1));
                    break;
                } else {
                    out.println("Неверный выбор!");
                }
            } else {
                in.nextLine();
                out.println("Это должно быть число!");
            }
        }



        //----------------------------------------------------------------------------------------


        // 6 (2)
        // Сравнение точек.
        //Измените сущность Точка из задачи 1.4.1. Переопределите метод сравнения объектов по
        //состоянию таким образом, чтобы две точки считались одинаковыми тогда, когда они
        //расположены в одинаковых координатах.
        // 1.4.1) Создаем Точку.
        //Измените сущность Точка из задачи 1.1. В соответствии с новыми требованиями создать объект
        //Точки можно только путем указания обеих координат:X и Y.
        //Необходимо выполнить следующие задачи:
        // Создайте и выведите на экран точку с координатами 3;5
        // Создайте и выведите на экран точку с координатами 25;6
        // Создайте и выведите на экран точку с координатами 7;8
        // 1.1) Точка координат.
        //Создайте сущность Точка, расположенную на двумерной плоскости, которая описывается:
        // Координата Х: число
        // Координата Y: число
        // Может возвращать текстовое представление вида “{X;Y}”
        //Необходимо создать три точки с разными координатами и вывести на экран их текстовое
        //представление.


        out.print("6 (2): ");
        while (true) {
            out.print("Хочешь сам добавить точки? (1 - да, 2 - нет) ");
            if (in.hasNextInt()) {
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    int k;
                    Point[] points;
                    while (true) {
                        out.println("Сколько будет точек? ");
                        if (in.hasNextInt()) {
                            k = in.nextInt();
                            in.nextLine();
                            if (k > 0) {
                                points = new Point[k];
                                break;
                            }
                            else {
                                out.println("Число должно быть положительным!");
                            }
                        }
                        else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    for (int i = 0; i < k; i++) {
                        out.println("Введи координаты для точки " + (i+1) + ":");
                        double x, y;
                        while (true) {
                            out.print("X: ");
                            if (in.hasNextDouble()) {
                                x = in.nextDouble();
                                break;
                            }else {
                                in.nextLine();
                                out.println("Это должно быть число!");
                            }
                        }
                        while (true) {
                            out.print("Y: ");
                            if (in.hasNextDouble()) {
                                y = in.nextDouble();
                                break;
                            }else {
                                in.nextLine();
                                out.println("Это должно быть число!");
                            }
                        }
                        points[i]=new Point(x,y);
                    }
                    out.println("Список твоих точек:");
                    for (int i = 0; i < k; i++) {
                        out.println((i+1)+": " + points[i]);
                    }
                    if (k > 1) {
                        while (true) {
                            out.print("Будем сравнивать точки? (1 - да, 2 - нет) ");
                            if (in.hasNextInt()) {
                                int ch = in.nextInt();
                                in.nextLine();
                                if (ch == 1) {
                                    int p1, p2;
                                    while (true) {
                                        out.println("Какие точки сравним из списка выше?");
                                        while (true) {
                                            out.print("Введи номер точки 1: ");
                                            if (in.hasNextInt()) {
                                                p1 = in.nextInt();
                                                if (p1 > 0 && p1 <= k) {
                                                    break;
                                                }
                                                else {
                                                    out.println("Введи нормальное число!");
                                                }
                                            }else {
                                                out.println("Это должно быть число!");
                                            }
                                        }
                                        while (true) {
                                            out.print("Введи номер точки 2: ");
                                            if (in.hasNextInt()) {
                                                p2 = in.nextInt();
                                                if (p2 > 0 && p2 <= k && p2 != p1) {
                                                    break;
                                                }
                                                else {
                                                    out.println("Введи нормальное число!");
                                                }
                                            }else {
                                                out.println("Это должно быть число!");
                                            }
                                        }
                                        out.println("Равна ли точка 1 точке 2? " + points[p1-1].equals(points[p2-1]));
                                        break;
                                    }
                                }
                                else if (ch == 2) {
                                    break;
                                }
                                else {
                                    out.println("Попробуй выбрать что-то из предложенных!");
                                }
                            }
                            else {
                                in.nextLine();
                                out.println("Это должно быть число!");
                            }
                        }
                    }
                    break;
                }
                else if (choice == 2) {
                    Point point1 = new Point(3, 5);
                    Point point2 = new Point(25, 6);
                    Point point3 = new Point(7, 8);

                    out.println("Точка 1: " + point1);
                    out.println("Точка 2: " + point2);
                    out.println("Точка 3: " + point3);

                    Point point4 = new Point(3, 5);
                    out.println("point1 равна point4: " + point1.equals(point4));
                    break;
                }
                else {
                    out.println("Попробуй ввести что-то из предложенных!");
                }
            }
            else {
                in.nextLine();
                out.println("Это должно быть число!");
            }
        }





        //-----------------------------------------------------------------------------------------

        // 7 (1)
        // Навести порядок.
        //Данная задача предполагает реорганизацию ранее написанных классов. Расположите все ранее
        //написанные классы по пакетам таким образом, чтобы логически близкие классы оказались
        //сгруппированы друг с другом. Имена пакетов должны иметь как минимум трехсоставную форму,
        //вида: ru.surname.type. Вместо surname следует подставить свою фамилию, а вместо type
        //подставить название логического блока. Например, классы описывающие точку, линию, ломаную
        //линию, фигуру, квадрат, треугольник, круг и прямоугольник можно расположить в пакете
        //ru.surname.geometry.

        //----------------------------------------------------------------------------------------------

        // 7 (2)
        // Главный метод.
        //Создайте пакет ru.surname.main (вместо surname необходимо подставить собственную
        //фамилию) в котором расположить класс с точкой входа в исполнение программы (public static void
        //main). Также следует проверить, что ни в одном другом пакете нет классов имеющих точку входа
        //в исполнение программы. В этом же пакете необходимо расположить класс (или интерфейс) с
        //методами из задач блока 2.5 и продемонстрировать их работоспособность.

        //----------------------------------------------------------------------------------------

        // 7 (3)
        // Возведение в степень.
        //Создайте метод принимающий две строки, в которых будут записаны числа X и Y. Возвращает
        //метод результат возведения X в степень Y. Для преобразования строки в число следует
        //использовать метод Integer.parseInt, а для возведения в степень метод Math.pow. Вызовите
        //разработанный метод передав туда параметры командной строки полученные точкой входа в
        //программу. Реализуйте метод так, что бы для возведения в степень и преобразования строки
        //использовались короткие имена статических методов.

        // javac -sourcepath ./src -d bin src/ru/permyakova/main/Main.java
        // java -classpath ./bin ru.permyakova.main.Main

        out.print("7 (3): ");
        if (args.length != 2) {
            out.println("Тут должны быть 2 числа!");
            return;
        }
        try {
            String x = args[0];
            String y = args[1];
            double result = power(x, y);
            out.println("Число " + x + " в степени " + y + "= " + result);
        } catch (NumberFormatException e) {
            out.println("Оба аргумента должны быть числами!");
        }




        //--------------------------------------------------------------------------------------

        // 8 (4)
        // 4.2.4 Клонирование точки.
        //Измените сущность Точка из 3.6.2.Переопределите метод клонирования, унаследованный от
        //класса Object, таким образом, чтобы при его вызове возвращался новый объект Точки, значения
        //полей которого будут копиями оригинальной Точки.


        out.print("8 (4): ");
        while (true) {
            out.print("Хочешь сам добавить точки? (1 - да, 2 - нет) ");
            if (in.hasNextInt()) {
                int choice = in.nextInt();
                in.nextLine();
                if (choice == 1) {
                    int k;
                    ArrayList<Point8_4> points = new ArrayList<>();
                    while (true) {
                        out.println("Сколько будет точек? ");
                        if (in.hasNextInt()) {
                            k = in.nextInt();
                            in.nextLine();
                            if (k > 0) {
                                break;
                            }
                            else {
                                out.println("Число должно быть положительным!");
                            }
                        }
                        else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    for (int i = 0; i < k; i++) {
                        out.println("Введи координаты для точки " + (i+1) + ":");
                        double x, y;
                        while (true) {
                            out.print("X: ");
                            if (in.hasNextDouble()) {
                                x = in.nextDouble();
                                break;
                            }else {
                                in.nextLine();
                                out.println("Это должно быть число!");
                            }
                        }
                        while (true) {
                            out.print("Y: ");
                            if (in.hasNextDouble()) {
                                y = in.nextDouble();
                                break;
                            }else {
                                in.nextLine();
                                out.println("Это должно быть число!");
                            }
                        }
                        points.add(new Point8_4(x,y));
                    }
                    out.println("Список твоих точек:");
                    for (int i = 0; i < points.size(); i++) {
                        out.println((i+1)+": " + points.get(i));
                    }
                    while (true) {
                        out.print("Будем клонировать точки? (1 - да, 2 - нет) ");
                        if (in.hasNextInt()) {
                            int ch = in.nextInt();
                            in.nextLine();
                            if (ch == 1) {
                                out.println("Список твоих точек:");
                                for (int i = 0; i < points.size(); i++) {
                                    out.println((i+1)+": " + points.get(i));
                                }
                                int p1;
                                while (true) {
                                    out.println("Какую точку будем клонировать из списка выше?");
                                    while (true) {
                                        out.print("Введи номер точки: ");
                                        if (in.hasNextInt()) {
                                            p1 = in.nextInt();
                                            if (p1 > 0 && p1 <= k) {
                                                break;
                                            }
                                            else {
                                                out.println("Введи нормальное число!");
                                            }
                                        }else {
                                            out.println("Это должно быть число!");
                                        }
                                    }
                                    Point8_4 clonePoint = points.get(p1-1).clone();
                                    points.add(clonePoint);
                                    out.println("Равна ли точка клону? " + points.get(p1-1).equals(clonePoint));
                                    out.println("Точка и клон - разные объекты? " + (points.get(p1-1) != clonePoint));
                                    break;
                                }
                            }
                            else if (ch == 2) {
                                break;
                            }
                            else {
                                out.println("Попробуй выбрать что-то из предложенных!");
                            }
                        }
                        else {
                            in.nextLine();
                            out.println("Это должно быть число!");
                        }
                    }
                    break;
                }
                else if (choice == 2) {
                    Point8_4 originalPoint = new Point8_4(3, 5);
                    Point8_4 clonedPoint = originalPoint.clone();

                    out.println("Оригинальная точка: " + originalPoint);
                    out.println("Клонированная точка: " + clonedPoint);

                    out.println("Оригинал и клон равны: " + originalPoint.equals(clonedPoint));
                    out.println("Оригинал и клон - разные объекты: " + (originalPoint != clonedPoint));
                    break;
                }
                else {
                    out.println("Попробуй ввести что-то из предложенных!");
                }
            }
            else {
                in.nextLine();
                out.println("Это должно быть число!");
            }
        }
    }
}