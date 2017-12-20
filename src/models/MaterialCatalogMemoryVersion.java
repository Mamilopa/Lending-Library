
package models;

import java.util.TreeMap;


public class MaterialCatalogMemoryVersion implements MaterialCatalogInterface{
    
    private TreeMap<String, Material> materialMap;
    
    public MaterialCatalogMemoryVersion (){
        
        materialMap= new TreeMap <String,Material>();// can store any object that extends Material
        //since the map/array etc only store reference to object so size does not matter
    }
    
    @Override
    public void addMaterial(Material newMaterial){
        materialMap.put(newMaterial.getID(), newMaterial);
    }
    @Override
    public TreeMap<String, Material> getMaterialMap (){
        return materialMap;
    }
    
    @Override
     public Material findMaterial (String title)throws MaterialNotFoundException{
    title = title.trim();
    
    
        for (Material nextMaterial: materialMap.values()) {
            if (nextMaterial.getTitle().equalsIgnoreCase(title)){
            return nextMaterial;
           
        }
    }
        throw new MaterialNotFoundException();
     }

   
    @Override
    public int getNumberOfMaterial() {
       return materialMap.size();
    }
}
