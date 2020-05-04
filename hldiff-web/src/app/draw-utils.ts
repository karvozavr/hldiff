export function drawLine(start: HTMLElement, end: HTMLElement, line: HTMLElement, color = 'rgb(0, 0, 0)') {
  clearLine(line);
//   setTimeout(() => {
//     let x1 = start.getBoundingClientRect().left;
//     const y1 = start.getBoundingClientRect().top + start.getBoundingClientRect().height / 2;
//     let x2 = end.getBoundingClientRect().left;
//     const y2 = end.getBoundingClientRect().top + window.scrollY + end.clientHeight / 2;
// 2
//     if (x1 < x2) { // code is to the left
//       x1 += start.getBoundingClientRect().width;
//     } else {
//       x2 += end.clientWidth;
//     }
//
//     document.documentElement.style.setProperty('--line-color', setAlpha(color, 1));
//     line.setAttribute('x1', x1.toString());
//     line.setAttribute('y1', y1.toString());
//     line.setAttribute('x2', x2.toString());
//     line.setAttribute('y2', y2.toString());
//   }, 1000);
}

export function clearLine(line1: HTMLElement) {
  line1.setAttribute('x1', '0');
  line1.setAttribute('y1', '0');
  line1.setAttribute('x2', '0');
  line1.setAttribute('y2', '0');
}

export function setAlpha(rgba, alpha) {
  if (rgba.startsWith('rgba')) {
    return rgba.replace(/ ([^ ]*)\)/, alpha);
  } else {
    return rgba.replace('rgb', 'rgba').replace(/(\))/, ', ' + alpha + ')');
  }
}
