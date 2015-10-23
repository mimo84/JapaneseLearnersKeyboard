//   <Key android:codes="119" android:keyLabel="w"/>

var ranges = {
  hiragana: {
    start: '\u3041',
    finish: '\u3096'
  },
  katakana: {
    start: '\u30A1',
    finish: '\u30F7'
  }
};

var first = '<Row>';


var build = function (x) {
  var lab = String.fromCodePoint(i);
  return '<Key android:codes="' + i + '" android:keyLabel="' + lab + '" />';
};

var updateRow = function () {
  first += '</Row>';
};

var y = 1;
for (var i = ranges.katakana.start.charCodeAt(0); i<ranges.katakana.finish.charCodeAt(0); i++) {
  if (y==12) {
    y = 1;
    first += '</Row><Row>';
  }
  first += build(i);
  y++;
}

if (y<=12) {
  updateRow();
}

console.log(first);
copy(first);
