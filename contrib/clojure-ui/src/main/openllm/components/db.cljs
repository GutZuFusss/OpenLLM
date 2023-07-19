(ns openllm.components.db
  "The branch of the app-db that saves data related to the chat view. Components
   are an abstract concept, this namespace is used to group all components' db
   branches; I do not think that there will be any actual fields in this namespace.
   The path to this branch can be expressed as:
   *root -> components*"
  (:require [openllm.components.model-selection.db :as model-selection-db]
            [openllm.components.chat.db :as chat-db]
            [clojure.spec.alpha :as s]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;                Spec                ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(s/def ::components-db (s/keys :req-un [::chat-db/chat-db]))
(s/def ::components-db (s/keys :req-un [::chat-db/chat-db]))

(defn initial-db
  []
  {:chat-db (chat-db/initial-db)
   :model-selection-db (model-selection-db/initial-db)})

(comment
  ;; check if initial-db is valid
  (s/valid? ::db (initial-db)))
