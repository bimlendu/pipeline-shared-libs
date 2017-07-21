def call(String cmd){
  sh('#!/bin/sh -e\n' + cmd)
}