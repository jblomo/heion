(ns heion.HelloWorldConfiguration
  (:import [org.codehaus.jackson.annotate JsonProperty]
           [org.hibernate.validator.constraints NotEmpty])
  (:gen-class :extends com.yammer.dropwizard.config.Configuration
              :state ^{JsonProperty () NotEmpty ()} config
              :init init))
              ;:state config))

(defn -init
  "Initialize config map"
  [& const]
  [const (atom {})])

(defn -get-template
  "Return the template string"
  [this]
  (:template @(.config this)))

(defn -get-default-name
  "Return the default name to greet"
  [this]
  (:default-name @(.config this)))
