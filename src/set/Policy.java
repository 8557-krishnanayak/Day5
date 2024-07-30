package set;

import java.time.LocalDate;
import java.util.Objects;

public class Policy implements Comparable<Policy> {
    private String name;
    private String policy_number;
    private LocalDate expiry_date;
    private String coverage_type;
    private double amount;

    public Policy(String name, String policy_number, LocalDate expiry_date, String coverage_type, double amount) {
        this.name = name;
        this.policy_number = policy_number;
        this.expiry_date = expiry_date;
        this.coverage_type = coverage_type;
        this.amount = amount;
    }

    @Override
    public int compareTo(Policy o) {
        return this.expiry_date.compareTo(o.expiry_date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Double.compare(amount, policy.amount) == 0 && Objects.equals(name, policy.name) && Objects.equals(policy_number, policy.policy_number) && Objects.equals(expiry_date, policy.expiry_date) && Objects.equals(coverage_type, policy.coverage_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, policy_number, expiry_date, coverage_type, amount);
    }

    @Override
    public String toString() {
        return "(" +
                "name='" + name + '\'' +
                ", policy_number='" + policy_number + '\'' +
                ", expiry_date=" + expiry_date +
                ", coverage_type='" + coverage_type + '\'' +
                ", amount=" + amount +
                ')';
    }


    public String getName() {
        return name;
    }

    public String getPolicy_number() {
        return policy_number;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public String getCoverage_type() {
        return coverage_type;
    }

    public double getAmount() {
        return amount;
    }
}
