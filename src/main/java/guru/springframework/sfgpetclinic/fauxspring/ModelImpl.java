package guru.springframework.sfgpetclinic.fauxspring;

import guru.springframework.sfgpetclinic.model.Vet;

import java.util.HashMap;
import java.util.Set;

public class ModelImpl implements Model {
    private HashMap<String, Set<Vet>> modelMap = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        modelMap.put(key, (Set<Vet>) o);
    }

    @Override
    public void addAttribute(Object o) {

    }

    public HashMap<String, Set<Vet>> getModelMap() {
        return modelMap;
    }
}
