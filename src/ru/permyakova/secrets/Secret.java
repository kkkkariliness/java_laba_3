package ru.permyakova.secrets;

public class Secret {
    private final String secretText, keeperName;
    private Secret previousKeeper, nextKeeper;

    // Создание секрета
    public Secret(String keeperName, String secretText) {
        this.keeperName = keeperName;
        this.secretText = secretText;
    }

    // Передача секрета
    public Secret(String keeperName, Secret previousKeeper) {
        this.keeperName = keeperName;
        this.previousKeeper = previousKeeper;
        this.secretText = modifySecret(previousKeeper.secretText);

        System.out.println(previousKeeper.keeperName + " говорит, что " + previousKeeper.secretText);

        previousKeeper.nextKeeper = this;
    }

    // Модификация секрета
    private String modifySecret(String originalText) {
        int N = (int) Math.ceil(originalText.length() * 10 / 100.0); // 10% от размера исходного текста
        int x = (int) (Math.random()*(N + 1)); // Х случайных символов в Х случайных мест
        StringBuilder modifiedText = new StringBuilder(originalText);
        for (int i = 0; i < x; i++) {
            int position = (int) (Math.random()*(modifiedText.length() + 1));
            char randomSimbol = (char) (Math.random()*1000);
            modifiedText.insert(position, randomSimbol);
        }
        return modifiedText.toString();
    }

    public String toString() {
        return keeperName + ": это секрет!";
    }

    // Номер хранителя в очереди
    public int getKeeperPosition() {
        int pos = 1;
        Secret secret_keeper = this.previousKeeper;
        while (secret_keeper != null) {
            pos++;
            secret_keeper = secret_keeper.previousKeeper;
        }
        return pos;
    }

    public String getKeeperName(){
        return this.keeperName;
    }

    // Сколько людей узнали секрет после текущего хранителя
    public int getNumberOfNextKeepers() {
        int count = 0;
        Secret thisKeeper = this;
        while (thisKeeper.nextKeeper != null) {
            count++;
            thisKeeper = thisKeeper.nextKeeper;
        }
        return count;
    }

    // Имя N-го хранителя секрета, до или после текущего
    public String getKeeperNameAt(int n) {
        Secret thisKeeper = this;
        int steps = Math.abs(n);
        if (n > 0) {
            while (steps > 0 && thisKeeper.nextKeeper != null) {
                thisKeeper = thisKeeper.nextKeeper;
                steps--;
            }
        } else {
            while (steps > 0 && thisKeeper.previousKeeper != null) {
                thisKeeper = thisKeeper.previousKeeper;
                steps--;
            }
        }
        return thisKeeper.keeperName;
    }

    // Разница в количестве символов текста секрета с N-м человеком
    public int getSecretLengthDifference(int n) {
        Secret thisKeeper = this;
        int steps = Math.abs(n);
        if (n > 0) {
            while (steps > 0 && thisKeeper.nextKeeper != null) {
                thisKeeper = thisKeeper.nextKeeper;
                steps--;
            }
        } else {
            while (steps > 0 && thisKeeper.previousKeeper != null) {
                thisKeeper = thisKeeper.previousKeeper;
                steps--;
            }
        }
        return Math.abs(this.secretText.length() - thisKeeper.secretText.length());
    }
}
