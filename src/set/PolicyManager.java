package set;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    public Set<Policy> hash = new HashSet<>();
    public Set<Policy> linked = new LinkedHashSet<>();
    public Set<Policy> tree = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hash.add(policy);
        linked.add(policy);
        tree.add(policy);
    }

    public Set<Policy> getAllUniquePolicies() {
        return new HashSet<>(hash);
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiry_soon = new TreeSet<>();

        LocalDate now = LocalDate.now();
        LocalDate soon = now.plusDays(30);

//        System.out.println(now);

//
        for (Policy policy : hash) {
//            System.out.println(policy.getExpiry_date() + "\t" + soon);
            if (policy.getExpiry_date().isBefore(soon)) {
                expiry_soon.add(policy);
            }
        }

//        System.out.println(expiry_soon);


        return expiry_soon;
    }

    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        Set<Policy> policiesByType = new HashSet<>();
        for (Policy policy : hash) {
            if (policy.getCoverage_type().equalsIgnoreCase(coverageType)) {
                policiesByType.add(policy);
            }
        }
        return policiesByType;
    }

    public Set<Policy> getDuplicatePolicies() {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> policyNumbers = new HashSet<>();
        for (Policy policy : hash) {
            if (!policyNumbers.add(policy.getPolicy_number())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }


    public static void main(String[] args) {
        PolicyManager system = new PolicyManager();
        system.addPolicy(new Policy("John Doe", "P001", LocalDate.of(2024, 7, 10), "Health", 5000.0));
        system.addPolicy(new Policy("Jane Smith", "P002", LocalDate.of(2024, 8, 30), "Auto", 3000.0));
        system.addPolicy(new Policy("Alice Johnson", "P003", LocalDate.of(2025, 1, 15), "Home", 7000.0));
        system.addPolicy(new Policy("Alice Johnson", "P001", LocalDate.of(2025, 1, 15), "Home", 7000.0));

        for (Policy p : system.getAllUniquePolicies()) {
            System.out.println(p);
        }

        for (Policy p : system.getPoliciesExpiringSoon()) {
            System.out.println(p);
        }

        for (Policy p : system.getPoliciesByCoverageType("Home")) {
            System.out.println(p);
        }


        for (Policy p : system.getDuplicatePolicies()) {
            System.out.println(p);
        }

    }
}