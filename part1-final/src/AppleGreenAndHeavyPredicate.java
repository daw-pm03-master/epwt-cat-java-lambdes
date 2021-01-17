public class AppleGreenAndHeavyPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.color.equals("green")
                && apple.weight >= 150;
    }
}
