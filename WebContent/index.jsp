<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!--
    Copyright 2010-2011 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with the License. A copy of the License is located at

        http://aws.Amazon/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
  -->
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Welcome</title>
  <style>
  body {
    color: #ffffff;
    background-color: #c7c7c7;
    font-family: Arial, sans-serif;
    font-size:14px;
    -moz-transition-property: text-shadow;
    -moz-transition-duration: 4s;
    -webkit-transition-property: text-shadow;
    -webkit-transition-duration: 4s;
    text-shadow: none;
  }
  body.blurry {
    -moz-transition-property: text-shadow;
    -moz-transition-duration: 4s;
    -webkit-transition-property: text-shadow;
    -webkit-transition-duration: 4s;
    text-shadow: #fff 0px 0px 25px;
  }
  a {
    color: #0188cc;
  }
  .textColumn, .linksColumn {
    padding: 2em;
  }
  .textColumn {
    position: absolute;
    top: 0px;
    right: 50%;
    bottom: 0px;
    left: 0px;

    text-align: right;
    padding-top: 11em;
    background-color: #0188cc;
    background-image: -moz-radial-gradient(left top, circle, #6ac9f9 0%, #0188cc 60%);
    background-image: -webkit-gradient(radial, 0 0, 1, 0 0, 500, from(#6ac9f9), to(#0188cc));
  }
  .textColumn p {
    width: 75%;
    float:right;
  }
  .linksColumn {
    position: absolute;
    top:0px;
    right: 0px;
    bottom: 0px;
    left: 50%;

    background-color: #c7c7c7;
  }

  h1 {
    font-size: 500%;
    font-weight: normal;
    margin-bottom: 0em;
  }
  h2 {
    font-size: 200%;
    font-weight: normal;
    margin-bottom: 0em;
  }
  ul {
    padding-left: 1em;
    margin: 0px;
  }
  li {
    margin: 1em 0em;
  }

  /* minigame */
.toast {
  color: #000;
  border: 1px solid #444;
  background-color: #eee;
  -webkit-border-radius: 8px;
  -moz-border-radius: 8px;
  border-radius: 8px;
  position: fixed;
  top: 0px;
  margin: 5px 0px;
  padding: 5px 10px 5px 5px;

  opacity: 0;
  -webkit-transition: opacity 1s;
  -moz-transition: opacity 1s;  
  transition: opacity 1s;
}
.toast.shown {
  opacity: 1;
  -webkit-transition: opacity 1s;  
  -moz-transition: opacity 1s;  
  transition: opacity 1s;
}
.toast div {
  font-size: 25px;
  float: left;
  margin-top: 5px;
  margin-bottom: 5px;
}
.toast h2 {
  font-size: 18px;
  margin: 0px;
  margin-left: 35px;
}
.toast p {
  font-size: 13px;
  margin: 3px 0px 0px 35px;
}


.pointsDisplay {
  position: fixed;
  left: 5px;
  bottom: 5px;
  background-color: #eee;
  border: 1px solid #444;
  padding: 5px;
  color: #000;
  font-size:175%;
}
  </style>
</head>
<body id="sample">
  <div class="textColumn">
    <h1>Congratulations</h1>
    <p>Your first AWS Elastic Beanstalk Application is now running on your own dedicated environment in the AWS Cloud
    test 343234
    </p>
  </div>
  
  <div class="linksColumn"> 
    <h2>What's Next?</h2>
    <ul>
      <li><a href="http://aws.amazon.com/elasticbeanstalk/ug/">Learn how to build, deploy and manage your own applications using AWS Elastic Beanstalk</a></li>
      <li><a href="http://aws.amazon.com/elasticbeanstalk/concepts/">AWS Elastic Beanstalk concepts</a></li>
      <li><a href="http://aws.amazon.com/elasticbeanstalk/deployment/">Learn how to create new application versions</a></li>
      <li><a href="http://aws.amazon.com/elasticbeanstalk/environments/">Learn how to manage your application environments</a></li>
    </ul>
    <h2>Download the AWS Reference Application</h2>
    <ul>
      <li><a href="http://aws.amazon.com/elasticbeanstalk/referenceapp/">Explore a fully-featured reference application using the AWS SDK for Java</a></li>
    </ul>
    <h2>AWS Toolkit for Eclipse</h2>
    <ul>
      <li><a href="http://aws.amazon.com/elasticbeanstalk/eclipse/">Developers may build and deploy AWS Elastic Beanstalk applications directly from Eclipse</a></li>
      <li><a href="http://aws.amazon.com/elasticbeanstalk/eclipsesc/">Get started with Eclipse and AWS Elastic Beanstalk by watching this video</a></li>
      <li><a href="http://aws.amazon.com/elasticbeanstalk/docs/">View all AWS Elastic Beanstalk documentation</a></li>
    </ul>
  </div>

<script type="text/javascript">
var keyseq = [];
var stats = {}
function checkKeyword(charSeqStr, achievementId, callback) {
  if (keyseq.toString().indexOf(charSeqStr) >= 0) {
    var count = stats[achievementId] || 0;
    if (ACH.started) {
      stats[achievementId] = ++count;
    }
    ACH.unlockAchievement(achievementId);
    if (callback) {
      callback(achievementId, count);
    }
    keyseq = [];
  }
}
function kp(e) {
  var konami  = "38,38,40,40,37,39,37,39,66,65";
  var konami2 = "38,38,40,40,37,39,37,39,98,97";
  var blur = "66,76,85,82";
  var help = "72,69,76,80";
  var servicename = "69,76,65,83,84,73,67,66,69,65,78,83,84,65,76,75";
  var xyzzy = "88,89,90,90,89";

  var keyCount = stats["keypress"] || 0;
  if (ACH.started) {
    stats["keypress"] = keyCount + 1;
  }
  keyseq.push(e.keyCode || e.charCode);

  // Konami is special, since it starts up ACH.
  if (keyseq.toString().indexOf(konami) >= 0 ||
      keyseq.toString().indexOf(konami2) >= 0) {
    ACH.start();

    var kc = stats["konami"] || 0;
    if (ACH.started) {
      kc = stats["konami"] = kc + 1;
    }

    if (kc === 1) {
      ACH.unlockAchievement("start");
    } else if (kc === 2) {
      ACH.unlockAchievement("konami");
    } else if (kc === 10) {
      ACH.unlockAchievement("konami3");
    }
    keyseq = [];
  }
  checkKeyword(blur, "blur", function(id, count) {
    document.getElementById('sample').className = 'blurry';
    setTimeout(function() { document.body.className = ''; }, 4000);
  });
  checkKeyword(help, "help");
  checkKeyword(servicename, "servicename");
  checkKeyword(xyzzy, "xyzzy");

}
window.onkeydown=kp;

/* achievement code */
function Achievement(id, title, points, description) {
  this.id = id;
  this.title = title;
  this.points = points;
  this.description = description;
  this.unlocked = false;
};

var ACH = {
  init: function() {
    this.started = false;
    this.score = 0;
    this.achievements = {};
  },
  start: function() {
    this.started = true;
    this.displayScore();
  },

  // Score functions
  updateScore: function() {
    if (this.pointsDisplay) {
      this.pointsDisplay.textContent = this.score + " points";
    }
  },
  displayScore: function() {
    if (this.pointsDisplay) {
      return;
    }
    var display = document.createElement('div');
    display.className = "pointsDisplay"
    if (typeof(this.score) != "undefined") {
      display.textContent = this.score + " points";
    }
    this.pointsDisplay = document.body.appendChild(display);
  },
  hideScore: function() {
    if (this.pointsDisplay) {
      ACH.pointsDisplay.parentNode.removeChild(ACH.pointsDisplay);
      delete this.pointsDisplay;
    }
  },

  // Achievement functions
  addAchievement: function(achievement) {
    this.achievements[achievement.id] = achievement;
  },
  unlockAchievement: function(achievementId) {
    if (!this.started) {
      return;
    }
    var achievement = this.achievements[achievementId];
    if (achievement && !achievement.unlocked) {
      achievement.unlocked = true;
      this.score += achievement.points;
      //alert(achievement.title + ": " + achievement.description + " " + achievement.points + " points");
      this.toast(achievement);
      this.updateScore();
    }
  },
  toast: function(achievement) {
    var toast = document.createElement('div');
    var title = document.createElement('h2');
    var desc = document.createElement('p');
    var points = document.createElement('div');

    toast.className = "toast";
    title.textContent = achievement.title;
    desc.textContent = achievement.description;
    points.textContent = achievement.points;
    toast.appendChild(points);
    toast.appendChild(title);
    toast.appendChild(desc);

    var liveToast = document.body.appendChild(toast);
    window.setTimeout(function() {
      liveToast.className += " shown";
    }, 100);
    window.setTimeout(function() {
      liveToast.className = "toast";
    }, 5000);
    window.setTimeout(function() {
      liveToast.parentNode.removeChild(liveToast);
    }, 6000);
  }
}
ACH.init();

// Setup some achievements
ACH.addAchievement(new Achievement("start", "Achievement Unlocked", 10, "Entered the konami code. Achievement tracking is now unlocked."));
ACH.addAchievement(new Achievement("konami", "Repeat Gamer", 20, "Re-entered the konami code. For good measure."));
ACH.addAchievement(new Achievement("konami3", "Play a Real Game Already", 30, "Entered the konami code 10 times."));
ACH.addAchievement(new Achievement("blur", "Kinda Blurry", 10, "Made all the text appear a bit blurry."));
ACH.addAchievement(new Achievement("help", "Customer Service", 10, "You asked for help. Too bad there isn't any help."));
ACH.addAchievement(new Achievement("servicename", "Don't Wear It Out", 20, "Entered the name of the service you're using."));
ACH.addAchievement(new Achievement("xyzzy", "Nothing Happens", 20, "Enter the magic word from Colossal Cave Adventure"));

</script>
</body>
</html>
