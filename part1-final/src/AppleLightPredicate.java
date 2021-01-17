public class AppleLightPredicate implements ApplePredicate {
    public boolean test(Apple apple) {
        return apple.weight <= 115;
    }
}
