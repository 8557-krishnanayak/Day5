package map;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    public Map<String, Policy> hash = new HashMap<>();
    public Map<String, Policy> linked = new LinkedHashMap<>();
    public Map<String, Policy> tree = new TreeMap<>();


    public void addPolicy(Policy policy) {
        hash.put(policy.getPolicy_number(), policy);
        linked.put(policy.getPolicy_number(), policy);
        tree.put(policy.getPolicy_number(), policy);
    }

    public Policy retrievePolicyByPolicyNumber(String policyNumber) {
        return hash.getOrDefault(policyNumber, null);
    }

    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> list = new ArrayList<>();
        for (Map.Entry<String, Policy> entry : hash.entrySet()) {
            if (entry.getValue().getCoverage_type().equalsIgnoreCase(coverageType)) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiry_soon = new ArrayList<>();

        LocalDate now = LocalDate.now();
        LocalDate soon = now.plusDays(30);


        for (Map.Entry<String, Policy> entry : hash.entrySet()) {
            System.out.println(entry.getValue().getExpiry_date() + " " + soon + "\t" + entry.getValue().getExpiry_date().isBefore(soon));
            if (entry.getValue().getExpiry_date().isBefore(soon)) {
                expiry_soon.add(entry.getValue());
            }
        }

        return expiry_soon;
    }

//    Remove policies that are expired

    public static void main(String[] args) {
        PolicyManager system = new PolicyManager();
        system.addPolicy(new Policy("John Doe", "P001", LocalDate.of(2024, 7, 10), "Health", 5000.0));
        system.addPolicy(new Policy("Jane Smith", "P002", LocalDate.of(2024, 8, 30), "Auto", 3000.0));
        system.addPolicy(new Policy("Alice Johnson", "P003", LocalDate.of(2025, 1, 15), "Home", 7000.0));
        system.addPolicy(new Policy("Alice Johnson", "P001", LocalDate.of(2024, 6, 15), "Home", 7000.0));


//        System.out.println(system);

        List<Policy> policiesExpiringSoon = system.getPoliciesExpiringSoon();
        System.out.println(policiesExpiringSoon);

    }


    @Override
    public String toString() {
        return "PolicyManager{\n\n" +
                "hash=" + hash +
                ",\n\n linked=" + linked +
                ",\n\n tree=" + tree +
                "\n\n}";
    }
}
