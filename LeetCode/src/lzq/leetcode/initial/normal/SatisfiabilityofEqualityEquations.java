package lzq.leetcode.initial.normal;

import java.util.*;

/**
 * SatisfiabilityofEqualityEquations
 *
 * @author luzheqi
 * @date 2019-02-12
 * @time 15:09
 */
public class SatisfiabilityofEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        if (null == equations || equations.length <= 0) {
            return true;
        }
        Map<Character, Set<Character>> values = new HashMap<>();
        for (String eq : equations) {
            char[] eqs = eq.toCharArray();
            if (eqs[1] == '=') {
                if (eqs[0] == eqs[3]) {
                    continue;
                } else {
                    if(!values.containsKey(eqs[0]) && !values.containsKey(eqs[3])){
                        values.put(eqs[0], new HashSet<>());
                        values.get(eqs[0]).add(eqs[3]);

                        values.put(eqs[3], new HashSet<>());
                        values.get(eqs[3]).add(eqs[0]);
                    }else if(!values.containsKey(eqs[0])){
                        values.put(eqs[0], new HashSet<>());
                        values.get(eqs[0]).add(eqs[3]);
                        values.get(eqs[0]).addAll(values.get(eqs[3]));

                        for(char c : values.get(eqs[3])){
                            if(c != eqs[3]) {
                                values.get(c).add(eqs[0]);
                            }
                        }
                        values.get(eqs[3]).add(eqs[0]);
                    }else if(!values.containsKey(eqs[3])){
                        values.put(eqs[3], new HashSet<>());
                        values.get(eqs[3]).add(eqs[0]);
                        values.get(eqs[3]).addAll(values.get(eqs[0]));

                        for(char c : values.get(eqs[0])){
                            if(c != eqs[0]) {
                                values.get(c).add(eqs[3]);
                            }
                        }
                        values.get(eqs[0]).add(eqs[3]);
                    }else{
                        values.get(eqs[0]).add(eqs[3]);
                        for(char c : values.get(eqs[0])){
                            if(c != eqs[0]) {
                                values.get(c).add(eqs[3]);
                            }
                            values.get(c).add(eqs[3]);
                        }

                        values.get(eqs[3]).add(eqs[0]);
                        for(char c : values.get(eqs[3])){
                            if(c != eqs[0]) {
                                values.get(c).add(eqs[3]);
                            }
                            values.get(c).add(eqs[0]);
                        }
                    }
                }
            }
        }

        for (String eq : equations) {
            char[] eqs = eq.toCharArray();
            if (eqs[1] == '!') {
                if (eqs[0] == eqs[3]) {
                    return false;
                } else {
                    if(values.containsKey(eqs[0]) && values.get(eqs[0]).contains(eqs[3])){
                        return false;
                    }else if(values.containsKey(eqs[3]) && values.get(eqs[3]).contains(eqs[0])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SatisfiabilityofEqualityEquations().equationsPossible(new String[]{"a==d","d==a","c!=c","c==d","f==f","f==a"}));
        System.out.println(new SatisfiabilityofEqualityEquations().equationsPossible(new String[]{"b==a", "a==b"}));
        System.out.println(new SatisfiabilityofEqualityEquations().equationsPossible(new String[]{"a==b", "b==c", "a==c"}));
        System.out.println(new SatisfiabilityofEqualityEquations().equationsPossible(new String[]{"a==b", "b!=c", "c==a"}));
        System.out.println(new SatisfiabilityofEqualityEquations().equationsPossible(new String[]{"c==c", "b==d", "x!=z"}));
    }
}
