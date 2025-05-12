import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// People kagan = new People(70, 190, "Kagan");
//System.out.println(kagan.toString());

public class Main {

    public static final String CYAN = "\033[0;36m";
    public static final String PURPLE = "\033[0;35m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String RED = "\033[0;31m";
    public static final String BLUE = "\033[0;34m";
    public static final String ORANGE = "\033[0;33m";
    public static final String RESET = "\033[0m";

    static ArrayList<Questions> mrThaiQuestions = new ArrayList<>();
    static ArrayList<Questions> mrRamenQuestions = new ArrayList<>();
    static ArrayList<Questions> mrRaQuestions = new ArrayList<>();
    static ArrayList<Questions> mrsAndersonQuestions = new ArrayList<>();
    static ArrayList<Questions> mrsMarekQuestions = new ArrayList<>();
    static ArrayList<Questions> mrsReyesQuestions = new ArrayList<>();
    static ArrayList<Questions> mrPalmerQuestions = new ArrayList<>();
    static ArrayList<Questions> mrsBarnettQuestions = new ArrayList<>();
    static ArrayList<Questions> mrsTurnerBullQuestions = new ArrayList<>();
    static ArrayList<Questions> mrsScavoneQuestions = new ArrayList<>();

    static Teacher mrThai = new Teacher(84, 202, "Mr.Tie", "AP Computer Science", 1, "R211", mrThaiQuestions,
            "Elective");
    static Teacher mrPalmer = new Teacher(74, 200, "Mr.Paulmere", "AP Psychology", 2, "??", mrPalmerQuestions,
            "Elective");
    static Teacher mrRaman = new Teacher(100, 300, "Mr.Ramen", "Final BOss", 3, "everywhere", mrRamenQuestions,
            "Staff");
    static Teacher mrsAnderson = new Teacher(67, 249, "Mrs.Ambersun", "AP World History", 5, "Q104",
            mrsAndersonQuestions, "Social Studies");
    static Teacher mrsMarek = new Teacher(53, 400, "Mrs.Marick", "Honors Freshman English", 6, "none",
            mrsMarekQuestions, "English");
    static Teacher mrsReyes = new Teacher(2, 50, "Mrs.Arrayes", "Honors Precalculus", 7, "R04", mrsReyesQuestions,
            "Math");
    static Teacher mrsBarnett = new Teacher(100, 300, "Mrs.Barnett", "Chemistry", 8, "R254", mrsBarnettQuestions,
            "Science");
    static Teacher mrsTurnerBull = new Teacher(100, 300, "Mrs.Turner-Bull", "Bio-Med", 9, "R254",
            mrsTurnerBullQuestions,
            "Science");
    static Teacher mrsScavone = new Teacher(100, 300, "Mrs.Scavone", "PE", 10, "GYM", mrsScavoneQuestions,
            "Fitness");
    static Teacher mrRa = new Teacher(100, 300, "Mr.Ra", "Enginnering", 11, "R254", mrRaQuestions,
            "Science");

    static int x;
    static boolean end;
    static int period;
    static int currNumCorrect;
    static int currTeacherCount;
    static int correctAnswerIndex;
    static Student player = new Student(0, 0, "kagan", "sophomore", 0.0);
    static int randBrunchEncounter;
    static int randLunchEncounter;
    static ArrayList<String> validResponses;
    static boolean isLunch = false;
    static boolean firstTime = true;
    static boolean graduated = false;

    public static void main(String[] args) throws Exception {
        player.setHeight(40);
        createQuestions();
        ArrayList<Teacher> Teachers = new ArrayList<>();
        ArrayList<Teacher> holdTeachers = new ArrayList<>();
        Teachers.add(mrThai);
        // Teachers.add(mrRaman);
        Teachers.add(mrsAnderson);
        Teachers.add(mrPalmer);
        Teachers.add(mrsMarek);
        Teachers.add(mrsReyes);
        Teachers.add(mrsBarnett);
        Teachers.add(mrsTurnerBull);
        Teachers.add(mrsScavone);
        Teachers.add(mrRa);

        Collections.shuffle(Teachers);
        while (Teachers.size() > 6) {
            Teachers.remove(Teachers.size() - 1);
        }

        String userRespLow = "";
        while (!end) {

            play(Teachers, userRespLow);
            userRespLow = processResponse(Teachers, validResponses);
        }
        if (graduated && player.getGPA() >= 2.5) {
            System.out.println(
                    "Congratulations! You have graduated from Amador Valley High School! You are on to great things in life!");
            System.out.println("Your final GPA is: " + player.getRoundedGPA());
            System.out.println("Your final IQ is: " + player.getIQ());
            System.out.println("Your final height is: " + player.getHeight());

        } else if (graduated && player.getGPA() < 2.5) {
            System.out.println(
                    "You did not graduate from Amador with good enough grades. You are now homeless. You will not be succesful. Try again next time.");
            System.out.println("Your final GPA is: " + player.getRoundedGPA());
            System.out.println("Your final IQ is: " + player.getIQ());
            System.out.println("Your final height is: " + player.getHeight());
        }
    }

    public static String askQuestions() {
        Scanner in = new Scanner(System.in);
        String userRespLow = in.nextLine().toLowerCase().strip();
        return userRespLow;
    }

    public static String processResponse(ArrayList<Teacher> Teachers, ArrayList<String> validResponses) {
        String userRespLow = askQuestions();
        if (userRespLow.equals("get me out of here")) {
            end = true;
            return userRespLow;
        }
        while (validResponses != null && !validResponses.contains(userRespLow)) {
            System.out.println("Please enter a valid response");
            userRespLow = askQuestions();
        }
        if (x == 0) {
            if (userRespLow.equals("1")) {
                x = 1;
            }
            if (userRespLow.equals("2")) {
                x = 2;
            }
        } else if (x == 1) {
            x = 8;
        } else if (x == 2) {
            if (userRespLow.equals("1")) {
                x = 3;
            }
            if (userRespLow.equals("2")) {
                x = 4;
            }
        } else if (x == 3 || x == 4) {
            x = 5;
        } else if (x == 8) {
            if (userRespLow.equals(correctAnswerIndex + "")) {
                System.out.println(GREEN + "You got the question right." + RESET + "\n");
                currNumCorrect++;
            } else {
                System.out.println(RED + "You got the question wrong." + RESET + "\n");

            }
            if (Teachers.get(period).getArrayList().isEmpty()) {
                x = 9;
            }
        } else if (x == 10) {
            x = 11;
        } else if (isLunch) {
            x = 16;
        }

        return userRespLow;
    }

    public static boolean checkExit(String response) {
        return !response.contains("0");
    }

    public static void play(ArrayList<Teacher> Teachers, String userRespLow) {
        if (x == 0) {
            System.out.println(
                    BLUE + "In this game, you will travese through a day of school, with some other special events");
            System.out.println(
                    "You will be asked questions by your teachers, and you must answer them correctly to survive and get a good enough gpa to graduate.");
            System.out.println("You will also encounter some random events that may help or hurt you.");
            System.out.println("Your goal is to survive the day and pass all your classes.");
            System.out.println("You will be given a GPA and IQ score at the end of the game.");
            System.out.println("If you ever want to leave, just type 'get me out of here' and you will leave school."
                    + RESET + "\n");
            System.out.println(GREEN + "Welcome to Amador Valley! Here is your class schedule:" + RESET);
            for (int i = 0; i < Teachers.size(); i++) {
                System.out.println(RED + Teachers.get(i).getName() + RESET);
            }
            System.out.println("\n" + GREEN + "Where would you like to go?" + RESET);
            System.out.println(RED + "[1] " + Teachers.get(0).getName());
            System.out.println("[2]" + " Leave School" + RESET);
            validResponses = new ArrayList<>();
            validResponses.add("1");
            validResponses.add("2");
        }
        if (x == 1) {
            System.out.println(YELLOW + "You have gone to " + Teachers.get(period).getName() + "'s class" + RESET);
            System.out.println(GREEN + Teachers.get(period).toString()
                    + ". Answer the questions to pass this class and survive. Are you ready?");
            System.out.println(RED + "[1] yes");
            System.out.println("[2] of course I was born ready" + RESET);
            validResponses = new ArrayList<>();
            validResponses.add("1");
            validResponses.add("2");

        } else if (x == 2) {
            System.out.println(
                    "Mr Ramen caught you. You have entered a battle with Mr Ramen. Answer his questions or face the consequences. Are you ready?");
            System.out.println("[1] no");
            System.out.println("[2] yes");
            validResponses = new ArrayList<>();
            validResponses.add("1");
            validResponses.add("2");
        } else if (x == 3) {
            validResponses = null;
            System.out.println("Too bad. The first questions is: What's the meaning of life?");
        } else if (x == 4) {
            validResponses = null;
            System.out.println("Great! The first question is: What is the meaning of life?");
        } else if (x == 5) {
            validResponses = null;
            System.out.println("Next Question: What comes after death?");
            x = 6;
        } else if (x == 6) {
            validResponses = null;
            System.out.println("Can you act like a monkey in real life?");
            x = 7;
        } else if (x == 7) {
            System.out.println(
                    "You got zero questions right. Embarrassing. You have been kicked out of school. Embarassing. You did not survive Amador. You did not pass go. Try again next time.");
            end = true;
        } else if (x == 8) {
            int currQues = (int) (Math.random() * Teachers.get(period).getArrayList().size());
            if (currTeacherCount == 0 || currTeacherCount >= 4) {
                currTeacherCount = 1;
            } else {
                currTeacherCount++;
            }

            Questions ques = Teachers.get(period).getArrayList().get(currQues);
            ArrayList<String> options = new ArrayList<>();
            options.addAll(ques.getOptions());

            Collections.shuffle(options);

            System.out.println(
                    GREEN + "The " + intToPlace(currTeacherCount) + " question is: "
                            + Teachers.get(period).getArrayList().get(currQues).getQuestion() + RESET);

            for (int i = 0; i < options.size(); i++) {
                System.out.println(RED + "[" + (i + 1) + "] " + options.get(i) + RESET);
                if (options.get(i).equals(ques.getCorrectOption())) {
                    correctAnswerIndex = i + 1;
                }
            }
            Teachers.get(period).getArrayList().remove(currQues);
            validResponses = new ArrayList<>();
            validResponses.add("1");
            validResponses.add("2");
            validResponses.add("3");
            validResponses.add("4");
        } else if (x == 9) {
            player.setIQ(player.getIQ() + currNumCorrect * 4);
            player.setGPA((double) (currNumCorrect * 4) / (4 * (1 + period)));
            player.setHeight(player.getHeight() + 3 * period);
            period++;
            if (period == 2) {
                System.out.println(YELLOW + "You have completed " + Teachers.get(period - 1).getSubject()
                        + ". Your current GPA is "
                        + player.getRoundedGPA() + ". Your current IQ is " + player.getIQ()
                        + ". Your current height is: " + player.getHeight() + RESET);
                x = 10;
            } else if (period == 4) {
                System.out.println(YELLOW + "You have completed " + Teachers.get(period - 1).getSubject()
                        + ". Your current GPA is "
                        + player.getRoundedGPA() + ". Your current IQ is " + player.getIQ()
                        + ". Your current height is: " + player.getHeight()
                        + ". It is currently lunch. Press anything to continue." + RESET);
                isLunch = true;
                validResponses = null;
                x = 16;
            } else if (period == Teachers.size()) {
                System.out.println("You have completed " + Teachers.get(period - 1).getSubject()
                        + ". Your time at Amador is over. Press anything to continue");
                end = true;
                graduated = true;
                validResponses = null;
            }

            else if (period != 2 || period != 4) {
                System.out.println(YELLOW + "You have completed " + Teachers.get(period - 1).getSubject()
                        + ". Your current GPA is "
                        + player.getRoundedGPA() + ". Your current IQ is " + player.getIQ()
                        + ". Your current height is: " + player.getHeight() + ". Your next class is: "
                        + Teachers.get(period).getSubject() + "." + " Press anything if you ready to go to class."
                        + RESET);
                x = 1;
                validResponses = null;
            }

        }
        if (x == 10) {
            System.out.println(
                    "It is currently brunch. You are super hungry, so go to the cafeteria and gobble down 3 waffles. ");
            randBrunchEncounter = (int) (Math.random() * 3) + 1;

            if (randBrunchEncounter == 1) {
                System.out.println(
                        GREEN + "You see someone nonchalantly talking to all the huzz with his green pants as he owns his haters. What do you do?"
                                + RESET);
                System.out.println(RED + "[1] Talk to him");
                System.out.println("[2] Walk away and gobble down 3 more waffles");
                System.out.println("[3] try to steal one of his huzz " + RESET);
            } else if (randBrunchEncounter == 2) {
                System.out.println(
                        GREEN + "Some nerd comes up to you and asks you what you got on the last AP Chem test. What do you do?"
                                + RESET);
                System.out.println(RED + "[1] Tell him the truth");
                System.out.println("[2] Lie and say you got a 100");
                System.out.println("[3] Tell him to shut up and eat your waffles" + RESET);

            } else if (randBrunchEncounter == 3) {
                System.out.println(
                        GREEN + "You see a big back John mounching down on 10 waffles while playing Brawl Stars instead of working on the Inheritance CS project thats due tomorrow. What do you do?"
                                + RESET);
                System.out.println(RED + "[1] Tell him to stop playing Brawl Stars and work on the project");
                System.out.println("[2] Join him and play Brawl Stars");
                System.out.println("[3] Make fun of him for 2020 #4 APCS FRQ" + RESET);
            }

            validResponses = new ArrayList<>();
            validResponses.add("1");
            validResponses.add("2");
            validResponses.add("3");
            x = 11;
        } else if (x == 11) {

            if (randBrunchEncounter == 1) {
                if (userRespLow.equals("1")) {
                    System.out.println(
                            YELLOW + "The stranger accepts you and gives you some of his aura. You are now a huzz.");
                    System.out.println("IQ +35");
                    System.out.println("Height +65" + RESET);
                    player.setIQ(player.getIQ() + 35);
                    player.setHeight(player.getHeight() + 65);
                }
                if (userRespLow.equals("2")) {
                    System.out.println(
                            YELLOW + "The stranger sees you walking away and notices you struggling. Because he is such a good person, he gives you some of his superhuman powers.");
                    System.out.println("IQ +250");
                    System.out.println("Height +250" + RESET);
                    player.setIQ(player.getIQ() + 250);
                    player.setHeight(player.getHeight() + 250);
                }
                if (userRespLow.equals("3")) {
                    System.out.println(
                            YELLOW + "Nothing gets past the stranger. He sees you trying to steal his huzz and gets mad. His fierce look make you cry. You time at Amador is ruined from the massive aura loss.");
                    System.out.println("IQ -100");
                    System.out.println("Height -100" + RESET);
                    player.setIQ(player.getIQ() - 100);
                    player.setHeight(player.getHeight() - 100);
                }
            } else if (randBrunchEncounter == 2) {
                if (userRespLow.equals("1")) {
                    System.out.println(
                            YELLOW + "You tell him you got 80% on your last. The nerd tells you got 100% on that test. He laughs at you for scoring lower than him and walks away. But you are an exemplary student who doesn't compare yourself to others.");
                    System.out.println("IQ +10");
                    System.out.println("Height +10" + RESET);
                    player.setIQ(player.getIQ() + 10);
                    player.setHeight(player.getHeight() + 10);
                }
                if (userRespLow.equals("2")) {
                    System.out.println(
                            YELLOW + "You tell him you got 100% on your last.The nerd doesn't believe so he gets Mr Raman. The nerd finds out that your are lying. You are so embarassed for being 'Caught in 4K'.");
                    System.out.println("IQ -20");
                    System.out.println("Height -20" + RESET);
                    player.setIQ(player.getIQ() - 20);
                    player.setHeight(player.getHeight() - 20);
                }
                if (userRespLow.equals("3")) {
                    System.out.println(
                            YELLOW + "You tell him to shut up and eat your waffles. The nerd gets mad and starts a fight with you. You win because have immense aura.");
                    System.out.println("IQ +1000");
                    System.out.println("Height +1000" + RESET);
                    player.setIQ(player.getIQ() + 1000);
                    player.setHeight(player.getHeight() + 1000);
                }
            } else if (randBrunchEncounter == 3) {
                if (userRespLow.equals("1")) {
                    System.out.println(
                            YELLOW + "You tell him to stop playing Brawl Stars and work on the project. John gets mad and sits you on with his very stinky aura. You walk away embarrassed.");
                    System.out.println("IQ -25");
                    System.out.println("Height -25" + RESET);
                    player.setIQ(player.getIQ() - 50);
                    player.setHeight(player.getHeight() - 50);
                }
                if (userRespLow.equals("2")) {
                    System.out.println(
                            YELLOW + "You join him and play Brawl Stars. The project doesn't get finished. Mr. Tye is not happy. John gets mad at you for playing brawl stars.");
                    System.out.println("IQ -15");
                    System.out.println("Height -15" + RESET);
                    player.setIQ(player.getIQ() - 15);
                    player.setHeight(player.getHeight() - 15);
                }
                if (userRespLow.equals("3")) {
                    System.out.println(
                            YELLOW + "You make fun of him for 2020 #4 APCS FRQ. John gets mad and starts a fight with you. You win.");
                    System.out.println("IQ +100");
                    System.out.println("Height +100" + RESET);
                    player.setIQ(player.getIQ() + 100);
                    player.setHeight(player.getHeight() + 100);
                }

            }
            System.out.println(YELLOW + "Brunch is over. It's time to go to your next class. Your current GPA is "
                    + player.getGPA() + ". Your current IQ is " + player.getIQ()
                    + ". Your current height is: " + player.getHeight() + ". Your next class is: "
                    + Teachers.get(period).getSubject() + "." + " Press anything if you ready to go to class." + RESET);
            x = 1;
            validResponses = null;
        } else if (x == 16) {
            randLunchEncounter = (int) (Math.random() * 2) + 1;

            System.out
                    .println(BLUE + "It is now lunch time! You head over to the lunch area to grab some food." + RESET);
            if (randLunchEncounter == 1) {
                System.out.println(
                        GREEN + "You ate a nasty hotdog and need to go to the bathroom. As you enter, you see five seniors about to set fire to a trash can, and they are blocking the only remaining stall. What do you do?"
                                + RESET);
                System.out.println(RED + "[1] Ask if you can join in on the FUN ");
                System.out.println("[2] Push your way through and poop");
                System.out.println("[3] Leave the bathroom and find another place to poop" + RESET);
            } else if (randLunchEncounter == 2) {
                System.out.println(
                        GREEN + "You ate your food fast and decided to go to the library to study. As you enter, you find a book called 'How to get a 5 on AP CSA Test'. What do you do?"
                                + RESET);
                System.out.println(RED + "[1] Steal the book and run away");
                System.out.println("[2] Ask the librarian if you can borrow it");
                System.out.println("[3] Leave the library and go to your next class" + RESET);

            } else if (randLunchEncounter == 3) {
                System.out.println(
                        GREEN + "You eat lunch with your friends when suddenly, a stranger approaches you and threatens you to give him your food. What do you do?"
                                + RESET);
                System.out.println(RED + "[1] Give him your food");
                System.out.println("[2] Fight him");
                System.out.println("[3] Run away" + RESET);
            }

            validResponses = new ArrayList<>();
            validResponses.add("1");
            validResponses.add("2");
            validResponses.add("3");

            isLunch = false;
            x = 17;
        } else if (x == 17) {

            if (randLunchEncounter == 1) {
                if (userRespLow.equals("1")) {
                    System.out.println(
                            YELLOW + "You join the seniors in burning the trash cans and have a great time. You feel super cool."
                                    + RESET);
                    validResponses = new ArrayList<>();
                    validResponses.add("1");
                    validResponses.add("2");
                    

                }
                if (userRespLow.equals("2")) {
                    System.out.println(
                            YELLOW + "You push your way through and poop. The seniors get mad and start a fight with you. You win. Easily.");
                    System.out.println("IQ + 100");
                    System.out.println("Height +50" + RESET);
                    player.setIQ(player.getIQ() + 100);
                    player.setHeight(player.getHeight() + 50);
                }
                if (userRespLow.equals("3")) {
                    System.out.println(
                            YELLOW + "You leave the bathroom and find another place to poop.");
                    System.out.println("IQ -5");
                    System.out.println("Height -5" + RESET);
                    player.setIQ(player.getIQ() - 5);
                    player.setHeight(player.getHeight() - 5);
                }
            } else if (randLunchEncounter == 2) {
                if (userRespLow.equals("1")) {
                    System.out.println(
                            YELLOW + "You steal the book and run away scot-free." + RESET);
                    System.out.println("IQ +10");
                    System.out.println("Height +10");
                    player.setIQ(player.getIQ() + 10);
                    player.setHeight(player.getHeight() + 10);
                }
                if (userRespLow.equals("2")) {
                    System.out.println(
                            YELLOW + "You ask the librarian if you can borrow it. She says no and kicks you out of the library.");
                    System.out.println("IQ -20");
                    System.out.println("Height -20" + RESET);
                    player.setIQ(player.getIQ() - 20);
                    player.setHeight(player.getHeight() - 20);
                }
                if (userRespLow.equals("3")) {
                    System.out.println(
                            YELLOW + "You leave the library and go to your next class.");
                    System.out.println("IQ +0");
                    System.out.println("Height +0" + RESET);
                    player.setIQ(player.getIQ() + 0);
                    player.setHeight(player.getHeight() + 0);
                }
            } else if (randLunchEncounter == 3) {
                if (userRespLow.equals("1")) {
                    System.out.println(
                            YELLOW + "You give him your food. He doesn't eat it and throws it away. You are now hungry.");
                    System.out.println("IQ -50");
                    System.out.println("Height -10" + RESET);
                    player.setIQ(player.getIQ() - 50);
                    player.setHeight(player.getHeight() - 25);
                }
                if (userRespLow.equals("2")) {
                    System.out.println(
                            RED + "You decide to fight him." + RESET);
                    int rand = (int) (Math.random() * 2) + 1;
                    if (rand == 1) {
                        System.out.println(BLUE
                                + "You win the fight, however you hurt the stranger so badly he gets lifted on a stretcher.");
                        System.out.println("BAD ENDING: You get arrested for assault and sentenced to life in prison.");
                        System.out.println("ENDING 2/4" + RESET);

                        end = true;
                    } else {
                        System.out.println(BLUE + "You lose the fight and get knocked out.");
                        System.out.println("You wake up in the hospital with a concussion.");
                        System.out.println("But Are You Even Alive?");
                        System.out.println("??? ENDING: You don't even know whats going on anymore.");
                        System.out.println("ENDING 3/4" + RESET);
                        end = true;

                    }
                    // MATH.RANDOM 1. YOU WIN THE FIGHT BUT ---
                    // 2. YOU LOSE THE FIGHT AND GET KNOCKED OUT
                }
                if (userRespLow.equals("3")) {
                    System.out.println(
                            YELLOW + "You run away, but you trip and drop all your food.");
                    System.out.println("GPA -1");
                    System.out.println("IQ -10");
                    System.out.println("Height -5" + RESET);
                    currNumCorrect -= 1;
                    player.setIQ(player.getIQ() - 10);
                    player.setHeight(player.getHeight() + 10);
                }

            }
            System.out.println(YELLOW + "Lunch is over. It's time to go to your next class. Your current GPA is "
                    + player.getRoundedGPA() + ". Your current IQ is " + player.getIQ()
                    + ". Your current height is: " + player.getHeight() + ". Your next class is: "
                    + Teachers.get(period).getSubject() + "." + " Press anything if you ready to go to class." + RESET);
            x = 1;
            validResponses = null;
        }

    }

    public static String intToPlace(int num) {
        if (num == 1) {
            return "first";
        } else if (num == 2) {
            return "second";
        } else if (num == 3) {
            return "third";
        } else if (num == 4) {
            return "fourth";
        } else if (num == 5) {
            return "fifth";
        } else if (num == 6) {
            return "sixth";
        }
        return "";

    }
    public static void createQuestions(){
         Questions APWorld1 = new Questions("The decline of maritime trade in the Indian Ocean",
                "The introduction of Confucianism to the Americas",
                "The unification of Europe under a single monarchy",
                "The spread of diseases such as smallpox, killing millions",
                "Which of the following was a major effect of the Columbian Exchange?");
        Questions APWorld2 = new Questions(
                "The Chinese civil service exams",
                "The Ottoman devshirme system",
                "The Indian caste system",
                "The European feudal system",
                "The encomienda system in colonial Latin America was most similar to:");
        Questions APWorld3 = new Questions(
                "The conquest of the empire by the Safavids",
                "The adoption of democracy by Sultan Selim III",
                "The spread of Buddhism into Anatolia",
                "The rise of industrialization in Europe",
                "Which factor contributed most to the decline of the Ottoman Empire in the 19th century?");
        Questions APWorld4 = new Questions(
                "Was led by Enlightenment philosophers",
                "Sought to restore absolute monarchy",
                "Was inspired by the American Revolution but failed",
                "Resulted in the abolition of slavery and independence from France",
                "The Haitian Revolution (1791-1804) differed from other Atlantic revolutions in that it:");

        Questions APCSA1 = new Questions(
                "It skips every other element.",
                "It causes an ArrayIndexOutOfBoundsException.",
                "It prints the array in reverse order.",
                "It prints each element of the array in order.",
                "What does this loop do?\nint[] arr = {1, 2, 3};\nfor (int num : arr) {\n    System.out.print(num + \" \");\n}");
        Questions APCSA2 = new Questions(
                "0 to 4",
                "1 to 5",
                "0 to 5",
                "1 to 6",
                "What range of values does this code generate?\nint num = (int)(Math.random() * 6) + 1;");
        Questions APCSA3 = new Questions(
                "10 to 20",
                "11 to 19",
                "10 to 19",
                "11 to 20",
                "What range does this code produce?\nint num = (int)(Math.random() * 10) + 11;");
        Questions APCSA4 = new Questions(
                "0",
                "1",
                "5",
                "4",
                "What is the value of this expression?\n(17 % 3 + 3 - 1)");

        // ===== PRE-CALCULUS QUESTIONS =====
        Questions PreCalc1 = new Questions(
                "0",
                "1/2",
                "√2/2",
                "1", // Correct answer
                "What is the value of cos(0°)?");

        Questions PreCalc2 = new Questions(
                "log₅(3)",
                "log₅(15)",
                "log₅(5)",
                "log₅(75)", // Correct answer
                "Which expression equals log₅(25) + log₅(3)?");

        Questions PreCalc3 = new Questions(
                "Shifted left 3 units",
                "Reflected over the y-axis",
                "Vertically stretched by 3",
                "Reflected over the x-axis", // Correct answer
                "How is the graph of f(x) = -√x transformed compared to f(x) = √x?");

        Questions PreCalc4 = new Questions(
                "0",
                "1",
                "2",
                "3", // Correct answer
                "How many real roots does x³ - 6x² + 11x - 6 have?");

        // ===== ENGLISH QUESTIONS =====
        Questions English1 = new Questions(
                "The group are protesting",
                "The group is protesting",
                "The group were protesting",
                "The group protests", // Correct answer
                "Which sentence demonstrates correct subject-verb agreement?");

        Questions English2 = new Questions(
                "Simile",
                "Metaphor",
                "Personification",
                "Oxymoron", // Correct answer
                "Which device is used in the phrase 'deafening silence'?");

        Questions English3 = new Questions(
                "Ethos",
                "Logos",
                "Pathos",
                "Kairos", // Correct answer
                "A speaker references 'the urgency of now' in a civil rights speech. Which rhetorical appeal is this?");

        Questions English4 = new Questions(
                "Idk",
                "ae95df",
                "#9b9705",
                "#D2B48C", // Correct answer
                "What color is Romeo's left toe?");

        // ===== AP PSYCHOLOGY QUESTIONS =====
        Questions Psych1 = new Questions(
                "Semantic encoding",
                "Visual encoding",
                "Acoustic encoding",
                "Elaborative encoding", // Correct answer
                "Which encoding method is most effective for remembering a grocery list by relating items to recipes?");

        Questions Psych2 = new Questions(
                "Sensorimotor stage",
                "Preoperational stage",
                "Formal operational stage",
                "Concrete operational stage", // Correct answer
                "In which stage do children understand that pouring liquid into a taller glass doesn't change its volume?");

        Questions Psych3 = new Questions(
                "Major depressive disorder",
                "Bipolar disorder",
                "Schizophrenia",
                "PTSD", // Correct answer
                "Which disorder is characterized by intrusive memories after a traumatic event?");

        Questions Psych4 = new Questions(
                "Cognitive dissonance",
                "Social loafing",
                "Group polarization",
                "Deindividuation", // Correct answer
                "When protesters wear masks and act aggressively due to anonymity, what phenomenon is this?");

        // ===== CHEMISTRY QUESTIONS (Mrs. Barnett) =====
        Questions Chem1 = new Questions(
                "The number of protons in the nucleus",
                "The number of electrons in the outer shell",
                "The sum of protons and neutrons",
                "The number of electron shells", // Correct answer
                "What does the atomic number of an element represent?");

        Questions Chem2 = new Questions(
                "Exothermic reaction",
                "Endothermic reaction",
                "Combustion reaction",
                "Synthesis reaction", // Correct answer
                "Which type of reaction absorbs heat from its surroundings?");

        Questions Chem3 = new Questions(
                "Protons and electrons",
                "Protons and neutrons",
                "Electrons and neutrons",
                "Quarks and leptons", // Correct answer
                "What two particles are found in an atom's nucleus?");

        Questions Chem4 = new Questions(
                "1s² 2s² 2p⁶ 3s² 3p⁶",
                "1s² 2s² 2p⁶ 3s² 3p⁶ 4s¹",
                "1s² 2s² 2p⁶ 3s² 3p⁶ 3d¹⁰ 4s² 4p⁵", // Correct answer
                "1s² 2s² 2p⁶ 3s² 3p⁶ 3d¹⁰ 4s² 4p⁶",
                "What is the electron configuration for bromine (Br)?");

        // ===== BIO-MED QUESTIONS (Mrs. Turner-Bull) =====
        Questions BioMed1 = new Questions(
                "Mitochondria",
                "Ribosomes",
                "Nucleus", // Correct answer
                "Endoplasmic reticulum",
                "Which organelle contains the cell's genetic material?");

        Questions BioMed2 = new Questions(
                "Adenine-Thymine and Guanine-Cytosine",
                "Adenine-Guanine and Thymine-Cytosine",
                "Adenine-Uracil and Guanine-Cytosine", // Correct answer
                "Adenine-Cytosine and Guanine-Uracil",
                "What are the correct base pairings in RNA?");

        Questions BioMed3 = new Questions(
                "Left ventricle → aorta → body → right atrium",
                "Right ventricle → pulmonary artery → lungs → left atrium", // Correct answer
                "Left atrium → left ventricle → lungs → right atrium",
                "Right atrium → right ventricle → body → left atrium",
                "Which sequence correctly describes pulmonary circulation?");

        Questions BioMed4 = new Questions(
                "Insulin",
                "Glucagon",
                "Hemoglobin", // Correct answer
                "Adrenaline",
                "Which protein carries oxygen in red blood cells?");
        // ===== PE QUESTIONS (Mrs. Scavone) =====
        Questions PE1 = new Questions(
                "Flexibility",
                "Cardiovascular endurance",
                "Muscular strength", // Correct answer
                "Body composition",
                "Which component of fitness is measured by how much weight you can lift?");

        Questions PE2 = new Questions(
                "ATP-PCr system",
                "Glycolytic system",
                "Oxidative system", // Correct answer
                "Krebs cycle",
                "Which energy system is primarily used during marathon running?");

        Questions PE3 = new Questions(
                "Increased heart rate",
                "Deeper breathing",
                "Muscle fatigue",
                "Increased flexibility", // Correct answer
                "Which is NOT an immediate effect of exercise on the body?");

        Questions PE4 = new Questions(
                "5-10 minutes",
                "10-15 minutes", // Correct answer
                "15-20 minutes",
                "20-30 minutes",
                "How long should a proper warm-up typically last?");

        // ===== ENGINEERING QUESTIONS (Mr. Ra) =====
        Questions Eng1 = new Questions(
                "Tensile strength",
                "Compressive strength",
                "Shear strength", // Correct answer
                "Torsional strength",
                "Which type of strength resists forces that try to slide parts past each other?");

        Questions Eng2 = new Questions(
                "Potential energy",
                "Kinetic energy",
                "Thermal energy",
                "Mechanical energy", // Correct answer
                "What type of energy is stored in a compressed spring?");

        Questions Eng3 = new Questions(
                "Newton's First Law",
                "Newton's Second Law", // Correct answer
                "Newton's Third Law",
                "Law of Universal Gravitation",
                "Which law states that force equals mass times acceleration (F=ma)?");

        Questions Eng4 = new Questions(
                "Copper",
                "Aluminum",
                "Steel", // Correct answer
                "Titanium",
                "Which material is most commonly used in structural engineering for buildings?");

        mrsAndersonQuestions.add(APWorld1);
        mrsAndersonQuestions.add(APWorld2);
        mrsAndersonQuestions.add(APWorld3);
        mrsAndersonQuestions.add(APWorld4);
        mrThaiQuestions.add(APCSA1);
        mrThaiQuestions.add(APCSA2);
        mrThaiQuestions.add(APCSA3);
        mrThaiQuestions.add(APCSA4);
        mrsReyesQuestions.add(PreCalc1);
        mrsReyesQuestions.add(PreCalc2);
        mrsReyesQuestions.add(PreCalc3);
        mrsReyesQuestions.add(PreCalc4);
        mrsMarekQuestions.add(English1);
        mrsMarekQuestions.add(English2);
        mrsMarekQuestions.add(English3);
        mrsMarekQuestions.add(English4);
        mrPalmerQuestions.add(Psych1);
        mrPalmerQuestions.add(Psych2);
        mrPalmerQuestions.add(Psych3);
        mrPalmerQuestions.add(Psych4);
        mrsBarnettQuestions.add(Chem1);
        mrsBarnettQuestions.add(Chem2);
        mrsBarnettQuestions.add(Chem3);
        mrsBarnettQuestions.add(Chem4);

        mrsTurnerBullQuestions.add(BioMed1);
        mrsTurnerBullQuestions.add(BioMed2);
        mrsTurnerBullQuestions.add(BioMed3);
        mrsTurnerBullQuestions.add(BioMed4);

        mrsScavoneQuestions.add(PE1);
        mrsScavoneQuestions.add(PE2);
        mrsScavoneQuestions.add(PE3);
        mrsScavoneQuestions.add(PE4);

        mrRaQuestions.add(Eng1);
        mrRaQuestions.add(Eng2);
        mrRaQuestions.add(Eng3);
        mrRaQuestions.add(Eng4);
    }
}