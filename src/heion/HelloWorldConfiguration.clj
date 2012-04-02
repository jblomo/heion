(ns heion.HelloWorldConfiguration
  (:import [org.codehaus.jackson.annotate JsonProperty]
           [org.hibernate.validator.constraints NotEmpty])
  (:gen-class :extends com.yammer.dropwizard.config.Configuration
              :state ^{JsonProperty {} NotEmpty {}} config
              :methods [[getTemplate [] String]
                        [getDefaultName [] String]]
              :init init))
              ;:state config))

(defn -init
  "Initialize config map"
  [& const]
  ; TODO currently string keys from YAML
  [const {"template" "In code Hello, %s!"
          "defaultName" "In code Stranger"}])

(defn -getTemplate
  "Return the template string"
  [this]
  (get (.config this) "template"))

(defn -getDefaultName
  "Return the default name to greet"
  [this]
  (get (.config this) "defaultName"))
