(ns heion.ParameterizedTypeClj
  (:gen-class :implements [java.lang.reflect.ParameterizedType]
              :state types
              :constructors {[Class clojure.lang.Sequential java.lang.reflect.Type] []}
              :init init))

(defn -getActualTypeArguments
  "Return Type objects"
  [this]
  (into-array (:actual (.types this))))

(defn -getOwnerType
  "Type object this type is a member of"
  [this]
  (:owner (.types this)))

(defn -getRawType
  "Type of class or interface that declared this type"
  [this]
  (:raw (.types this)))

(defn -init
  "Static factory"
  [raw-type actual-types owner-type]
  [[] {:raw raw-type :actual actual-types :owner owner-type}])

