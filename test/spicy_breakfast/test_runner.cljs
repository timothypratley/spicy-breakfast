(ns spicy-breakfast.test-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [spicy-breakfast.logic-test]))

(doo-tests 'spicy-breakfast.logic-test)
