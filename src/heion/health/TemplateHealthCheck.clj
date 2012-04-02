(ns heion.health.TemplateHealthCheck
  (:import [com.yammer.metrics.core HealthCheck$Result])
  (:gen-class :extends com.yammer.metrics.core.HealthCheck
              :state template
              :init init))

(defn -init
  "Set the template"
  [template]
  [[template] template])

(defn -check
  "Return a healthy response or throw an exception"
  [this]
  (let [saying (String/format (.template this) "TEST")]
    (if (.contains saying "TEST")
      (HealthCheck$Result/healthy)
      (HealthCheck$Result/unhealthy "template doesn't inclde a name"))))
