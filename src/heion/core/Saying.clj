(ns heion.core.Saying
  (:gen-class :state state
              :init init
              :constructors {[long String] []}))

(defn -init
  "Initializer"
  [id content]
  [[] {:id id :content content}])

(defn -getId
  [this]
  (:id (.state this)))

(defn -getContent
  [this]
  (:content (.state this)))
