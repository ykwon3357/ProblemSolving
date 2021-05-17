# -*- coding: utf-8 -*-
# ---
# jupyter:
#   jupytext:
#     formats: ipynb,py:light
#     text_representation:
#       extension: .py
#       format_name: light
#       format_version: '1.5'
#       jupytext_version: 1.11.2
#   kernelspec:
#     display_name: Python 3
#     language: python
#     name: python3
# ---

# +
a, b = map(int, input().split())
oa, ob = a, b

while b: # 유클리드 호제법
    t = b
    b = a % b
    a = t

print(a)
print(oa*ob//a)
# -


