import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Commands<T extends Human> {
    private Family<T> family;

    public Commands(Family<T> family) {
        this.family = family;
    }

    public T search(String sName) {
        T find = null;
        if (sName.isEmpty() || sName.equalsIgnoreCase("no")) {
            find = null;
        } else {
            for (T human : family) {
                if (human.getName().contains(sName)) {
                    find = human;
                }
            }
        }
        return find;
    }

    public List<T> getParents(T child) {
        List<T> parents = new ArrayList<>();
        if (child.getFather() != null) {
            parents.add((T) child.getFather());
        }
        if (child.getMother() != null) {
            parents.add((T) child.getMother());
        }
        return parents;
    }

    public List<T> getChildrens(List<T> parents) {
        List<T> children = new ArrayList<>();
        for (T parent : parents) {
            if (parent.getChildren() != null) {
                children.addAll((Collection<? extends T>) parent.getChildren());
            }
        }
        Set<T> uniq_children = new HashSet<>(children);
        children = new ArrayList<>(uniq_children);
        return children;
    }

    public List<T> check(String sName) {
        T find = search(sName);
        List<T> parents = getParents(find);
        if (parents.isEmpty())
            return parents;
        else {
            List<T> children = getChildrens(parents);
            children.remove(find);
            return children;
        }
    }

    public StringBuilder getBroAndSis(String sName) {
        List<T> res = check(sName);
        StringBuilder result = new StringBuilder(sName + ": ");
        if (res.isEmpty())
            result.append("нет братьев и систер");
        else {
            for (T human : res) {
                result.append(human.getName() + " ");
            }
        }
        return result;
    }
}
